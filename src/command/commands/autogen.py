"""
Author: PeerHeer
Inspired by: https://github.com/Arcensoth/pyckaxe

Automatically generates Kotlin code from the command registry.
Command registry source: https://raw.githubusercontent.com/Arcensoth/mcdata/master/generated/reports/command.json

The registry is modified in the following way(s):
- The "run" literal redirects to "".
"""
from textwrap import dedent, indent
from typing import Union
import json
import re
import os
import sys
import traceback


NAME_SUFFIX = "Command"
REDIRECT_SUFFIX = "Redirect"
NEWLINE = "\n"
INDENT = "    "
EXTENSION = ".kt"
IMPORTS = dedent(
    """\
    package command.commands

    import command.baseclasses.CommandArgument
    import command.baseclasses.CommandLiteral
    import command.baseclasses.CommandNode
    import vector.Coordinates
    import target.Selector
    """
)
RESERVED_KEYWORDS = ["as", "if", "in"]
PARSER_DICT = {
    "brigadier:bool": "Boolean",                # done
    "brigadier:double": "Double",               # done
    "brigadier:float": "Float",                 # done
    "brigadier:integer": "Int",                 # done
    "brigadier:string": "String",
    "minecraft:block_pos": "String",
    "minecraft:block_predicate": "String",
    "minecraft:block_state": "String",
    "minecraft:color": "String",
    "minecraft:column_pos": "String",
    "minecraft:component": "String",
    "minecraft:dimension": "String",
    "minecraft:entity": "Selector",
    "minecraft:entity_anchor": "String",
    "minecraft:entity_summon": "String",
    "minecraft:function": "String",
    "minecraft:game_profile": "String",
    "minecraft:int_range": "IntRange",
    "minecraft:item_enchantment": "String",
    "minecraft:item_predicate": "String",
    "minecraft:item_slot": "String",
    "minecraft:item_stack": "String",
    "minecraft:message": "String",
    "minecraft:mob_effect": "String",
    "minecraft:nbt_compound_tag": "String",
    "minecraft:nbt_path": "String",
    "minecraft:nbt_tag": "String",
    "minecraft:objective": "String",
    "minecraft:objective_criteria": "String",
    "minecraft:operation": "String",
    "minecraft:particle": "String",
    "minecraft:resource_location": "String",
    "minecraft:rotation": "String",
    "minecraft:scoreboard_slot": "String",
    "minecraft:score_holder": "String",
    "minecraft:swizzle": "String",
    "minecraft:team": "String",
    "minecraft:time": "String",
    "minecraft:uuid": "String",
    "minecraft:vec2": "String",
    "minecraft:vec3": "Coordinates",
}

# Used to store nodes.
stack = []
# Used to store literal nodes.
literal_stack = []
# Used to store the amount of executable nodes.
executable = 0
# Used to store redirect classes.
redirect_classes = {}
# Used to check if a comparison operation was already added or not.
comparison_operation = False
# Used to store the currently opened file.
opened_file = None
# Used to check whether the redirect class should be written to file or not.
write_redirect_class = False


class Class:
    pass

class Class:
    """
    Superclass for literal and argument classes.
    """
    def __init__(self, arg_or_literal: str, parent: Class, is_optional: bool, is_executable: bool):
        self.raw_name = to_capital_case(arg_or_literal)
        self.parent = parent
        self.argument_functions = []
        self.literal_variables = []
        self.is_optional = is_optional
        self.is_executable = is_executable

        if parent is None:
            self.name = self.raw_name + NAME_SUFFIX
            self.raw_name_inherited = self.raw_name
        else:
            self.raw_name_inherited = self.parent.raw_name_inherited + self.raw_name
            self.name = self.raw_name_inherited + NAME_SUFFIX

    def get_node_type(self) -> str:
        """
        Return the type of the parent node.
        """
        return "CommandNode?" if self.root_node else "CommandNode"

    def get_head(self) -> str:
        """
        Return the header of the class.
        """
        raise NotImplementedError()

    def get_body(self) -> str:
        """
        Return the body of the class.
        """
        return strip_whitespace(
    f"""
    {(NEWLINE + INDENT).join(map(str, self.literal_variables))}

    {(NEWLINE + NEWLINE).join(map(lambda x: indent(str(x), INDENT), [function for function in self.argument_functions if function.add_to_functions]))}
    """
        )

    def __str__(self):
        """
        Return the class in string forme.
        """
        head = self.get_head()
        body = self.get_body()

        if body == "":
            return head

        return strip_whitespace(
f"""
{head} {{
    {body}
}}
"""
        )


class LiteralClass(Class):
    """
    Class representing a CommandLiteral.
    """
    def __init__(self, literal: str, parent: Class=None, is_optional=False, is_executable=False, root_node=False, literal_name=None):
        self.invoke_functions = []
        self.literal = literal
        self.root_node = root_node
        self.literal_name = literal_name or literal

        super().__init__(literal, parent, is_optional, is_executable)

    def get_head(self) -> str:
        """
        Return the class header.
        """
        quoted_literal = f"\"{self.literal_name}\""

        return strip_whitespace(
f"""
class {self.name}(
    parent: {self.get_node_type()}{',' + NEWLINE + INDENT + 'literal: String? = ' + quoted_literal if self.is_optional else ''}
): CommandLiteral(parent, {'literal' if self.is_optional else quoted_literal})
"""
        )

    def get_body(self) -> str:
        """
        Add the invoke function to the body if it is not None.
        """
        return strip_whitespace(super().get_body() + NEWLINE + NEWLINE + (NEWLINE + NEWLINE).join(map(lambda x: indent(str(x), INDENT), [function for function in self.invoke_functions])))


class LiteralVariable:
    """
    Represents a literal variable in a node.
    """
    def __init__(self, literal_class: LiteralClass, redirect_class=None):
        self.name = literal_class.literal
        self.name = self.name if self.name not in RESERVED_KEYWORDS else f"`{self.name}`"
        self.type = literal_class.name
        self.redirect_class = redirect_class

    def __str__(self):
        return strip_whitespace(f"""val {self.name} = {self.type}(this){'.redirect()' if self.redirect_class else ''}""")


class InvokeFunction:
    """
    Represents an 'invoke' operator overload in a CommandLiteral.
    """
    def __init__(self, literal_class: LiteralClass, return_type=None, arguments=[]):
        self.literal_class = literal_class
        self.return_type = return_type
        self.arguments = arguments

    def get_return_type(self) -> str:
        """
        Gets the return type as a string.
        """
        return self.return_type or self.arguments[-1].return_type

    def get_arguments(self) -> str:
        """
        Convert the function arguments into a string.
        """
        return ", ".join([f"{function.argument_name}: {function.argument_class.get_type()}" for function in self.arguments])

    def get_function_call(self) -> str:
        """
        Convert the function call chain to a string.
        """
        return ".".join([f"{function.name}({function.argument_name})" for function in self.arguments])

    def __str__(self):
        return strip_whitespace(
f"""
operator fun invoke({self.get_arguments()}): {self.get_return_type()} {{
    return {self.get_function_call()}
}}
"""
        )


class ArgumentClass(Class):
    """
    Represents a CommandArgument.
    """
    def __init__(self, argument: str, type: str, parent: Class=None, is_optional=False, is_executable=False):
        self.type = type
        self.argument = argument

        super().__init__(argument, parent, is_optional, is_executable)

    def get_type(self) -> str:
        """
        Gets the type as a string.
        """
        return f"{self.type}{'? = null' if self.is_optional else ''}"

    def get_head(self) -> str:
        """
        Return the class header.
        """
        return strip_whitespace(
f"""
class {self.name}(
    parent: CommandNode,
    {self.argument}: {self.get_type()}
): CommandArgument(parent, {self.argument})
"""
        )


class ArgumentFunction:
    """
    Represents an argument function in a node.
    """
    def __init__(self, argument_class: ArgumentClass, add_to_functions=True, redirect_class=None):
        self.name = argument_class.argument
        self.argument_name = self.name
        self.argument_type = argument_class.type
        self.return_type = argument_class.name
        self.add_to_functions = add_to_functions
        self.redirect_class = redirect_class
        self.argument_class = argument_class

    def __str__(self):
        return_type = self.return_type if self.redirect_class is None else self.redirect_class.return_type

        return strip_whitespace(
f"""
fun {self.name}({self.argument_name}: {self.argument_class.get_type()}): {return_type} {{
    return {self.return_type}(this, {self.argument_name}){'.redirect()' if self.redirect_class is not None else ''}
}}
"""
        )


class RedirectClass:
    """
    Represents a class created for redirecting to a different node.
    """
    def __init__(self, name):
        self.return_type = "Root" + to_capital_case(name) + NAME_SUFFIX
        self.name = self.return_type + REDIRECT_SUFFIX

    def __str__(self):
        return strip_whitespace(
f"""
abstract class {self.name}(
    parent: CommandNode?,
    argOrLiteral: Any?
): CommandNode(parent, argOrLiteral) {{
    fun redirect(): {self.return_type} {{
        return {self.return_type}(this, null)
    }}
}}
"""
        )


class LiteralRedirectClass(LiteralClass):
    """
    Represents a LiteralClass that inherits from a redirect class.
    """
    def __init__(self, literal: str, parent: Class, redirect_class: RedirectClass, is_optional=False, is_executable=False, root_node=False, literal_name=None):
        self.redirect_class = redirect_class
        super().__init__(literal, parent, is_optional, is_executable, root_node, literal_name)

    def get_head(self) -> str:
        return super().get_head().replace("CommandLiteral", self.redirect_class.name)


class ArgumentRedirectClass(ArgumentClass):
    """
    Represents an ArgumentClass that inherits from a redirect class.
    """
    def __init__(self, argument: str, type: str, parent: Class, redirect_class: RedirectClass, is_optional=False, is_executable=False):
        self.redirect_class = redirect_class
        super().__init__(argument, type, parent, is_optional, is_executable)

    def get_head(self) -> str:
        return super().get_head().replace("CommandArgument", self.redirect_class.name)


def to_capital_case(string: str) -> str:
    """
    Convert camelCase to CapitalCase.
    """
    if len(string) <= 1:
        return string.upper()
    return string[0].upper() + string[1:]

def to_lower_case(string: str) -> str:
    """
    Convert CapitalCase to camelCase.
    """
    if len(string) <= 1:
        return string.lower()
    return string[0].lower() + string[1:]

def snake_to_camel(string: str, split="_"):
    """
    Convert snake_case to camelCase.
    """
    return to_lower_case("".join(map(to_capital_case, string.split(split))))


def strip_whitespace(string: str) -> str:
    """
    Strip all whitespace characters.
    """
    return string.strip()

def strip_spaces(string: str) -> str:
    """
    Strip spaces only.
    """
    return string.strip(" ")

def strip_newlines(string: str) -> str:
    """
    Strip newlines only.
    """
    return string.strip(NEWLINE)


def is_literal(arg_or_literal: Class) -> bool:
    """
    Class is an instance of LiteralClass.
    """
    return isinstance(arg_or_literal, LiteralClass)

def is_argument(arg_or_literal: Class) -> bool:
    """
    Class is an instance of ArgumentClass.
    """
    return isinstance(arg_or_literal, ArgumentClass)


def iterate_children(k, v):
    """
    Iterate over the children of a node and write to file.
    """
    global executable
    global opened_file
    global write_redirect_class

    # Create instance and add it to the stack.
    element = process_element(k, v)

    if element is None:
        return

    instance, redirect_class = element
    stack.append(instance)

    # Open a new file if the current node is a root command.
    if instance.parent and instance.parent.raw_name == "Root":
        if opened_file is not None:
            opened_file.close()

        opened_file = open(instance.raw_name + EXTENSION, "w")
        opened_file.write(IMPORTS)
        instance.is_optional = True

    if instance.raw_name == "Root":
        instance.is_optional = True

    # Write redirect class to file.
    if redirect_class and write_redirect_class:
        opened_file.write(str(redirect_class) + f"{NEWLINE}{NEWLINE}")
        write_redirect_class = False

    # If the instance is a literal, add it to the literal_stack.
    if is_literal(instance):
        literal_stack.append(instance)

    # Loop over children.
    if "children" in v.keys():
        children = v["children"]

        for k, v in children.items():
            iterate_children(k, v)

    # Process element after all children are processed.
    element = stack.pop()

    # Remove the element from the other stacks.
    if element.is_executable:
        executable -= 1
    if is_literal(element):
        literal_stack.pop()

    # Open the Root file if the command is root.
    if element is not None and element.raw_name == "Root":
        opened_file.close()
        opened_file = open(element.raw_name + EXTENSION, "w")
        opened_file.write(IMPORTS)

        # Remove recursive variables
        new_literal_variables = [variable for variable in element.literal_variables if variable.name != "execute"]
        element.literal_variables = new_literal_variables
    opened_file.write(NEWLINE + str(element) + NEWLINE)

    # If the command is a root command, add a new variable to create the command to the file.
    if len(stack) == 1:
        opened_file.write(str(element.parent.literal_variables[-1]).replace("this", "null"))


def construct_argument(name, data, node_type, parent, is_executable, is_optional, redirect_class, type=None):
    """
    Construct argument. If redirect, construct ArgumentRedirectClass, else ArgumentClass.
    Add a argument to the first literal parent, if it exists.
    """
    redirect_argument = False

    # Get argument type.
    if type is None:
        parser = data["parser"]
        argument_type = PARSER_DICT[parser]
    else:
        argument_type = type

    if redirect_class is None:
        instance = ArgumentClass(name, argument_type, parent, is_optional, is_executable)
    else:
        instance = ArgumentRedirectClass(name, argument_type, parent, redirect_class, is_optional, is_executable)
        redirect_argument = True

    if is_literal(parent):
        # Add argument function and invoke function to parent.
        argument_function = ArgumentFunction(instance, redirect_class=redirect_class)
        parent.argument_functions.append(argument_function)
        parent.invoke_functions.append(InvokeFunction(parent, arguments=[argument_function]))
    else:
        # Add argument function to first literal parent.
        literal_parent = literal_stack[-1]
        argument_function = ArgumentFunction(instance, False, redirect_class=redirect_class)
        literal_parent.argument_functions.append(argument_function)

        # If the parent doesn't have any argument functions yet, add an argument to the invoke
        # function of the literal parent.
        # Else, add a new invoke function to the literal parent. This way, invoke functions can
        # overload to allow for multiple options.
        if len(parent.argument_functions) + len(parent.literal_variables) == 0:
            literal_parent.invoke_functions[-1].arguments.append(argument_function)
        elif len(parent.literal_variables) > 0:
            literal_parent.invoke_functions.append(InvokeFunction(parent, arguments=literal_parent.invoke_functions[-1].arguments + [argument_function]))
        else:
            literal_parent.invoke_functions.append(InvokeFunction(parent, arguments=literal_parent.invoke_functions[-1].arguments[:-1] + [argument_function]))

        # Add new argument function to the parent.
        parent.argument_functions.append(ArgumentFunction(instance, redirect_class=redirect_class))

    # Change the return type of the invoke function of the literal parent to the return type
    # of the redirect class.
    if redirect_argument:
        literal_parent = literal_stack[-1]
        literal_parent.invoke_functions[-1].return_type = redirect_class.return_type

    return instance


def construct_literal(name, data, node_type, parent, is_executable, is_optional, redirect_class, literal_name):
    """
    Construct literal. If redirect, construct LiteralRedirectClass, else LiteralClass.
    Add a literal variable to the parent, if it exists.
    """
    # Whether the node is a root node or not. Used to determine if the parent is optional.
    root_node = name == "root" or (parent and parent.raw_name == "Root")

    if redirect_class is None:
        instance = LiteralClass(name, parent, is_optional, is_executable, root_node, literal_name)
    else:
        instance = LiteralRedirectClass(name, parent, redirect_class, is_optional, is_executable, root_node, literal_name)

    # Add literal variable to parent.
    if parent is not None:
        parent.literal_variables.append(LiteralVariable(instance, redirect_class))

    return instance


def get_redirect_class(redirect_name: str):
    """
    Returns the redirect class for the current node.
    """
    global write_redirect_class

    if redirect_name not in redirect_classes:
        redirect_class = RedirectClass(redirect_name)
        redirect_classes[redirect_name] = redirect_class
        write_redirect_class = True
    else:
        redirect_class = redirect_classes[redirect_name]

    return redirect_class


def process_element(name, data):
    """
    Processes the current node.
    """
    global executable
    global comparison_operation
    global opened_file

    instance = None

    # Name used for literal string.
    literal_name = name
    # Name used for constructing the class and variable names.
    # Underscores and hyphens are replced and '*' is interpreted as "all".
    name = snake_to_camel(snake_to_camel(name, "-")) if name != "*" else "all"
    # Type of node: "literal", "argument" or "unknown".
    node_type = data["type"]
    # Parent of the current node.
    parent = None if len(stack) == 0 else stack[-1]
    # Whether the current node is executable.
    is_executable = "executable" in data.keys()
    # Whether the current node is optional.
    is_optional = executable != 0

    # Get the redirect class.
    # Don't forget to let `run` redirect to ""!
    if "redirect" not in data.keys():
        redirect_class = None
    else:
        redirect_name = data["redirect"][0]
        redirect_class = get_redirect_class(redirect_name)

    # Handle node types.
    if node_type == "argument":
        instance = construct_argument(name, data, node_type, parent, is_executable, is_optional, redirect_class)
    elif node_type == "literal" or node_type == "root":
        # If it is an if/unless score operation, only do it once.
        # These operations are presented as literals (WhY mAhJoNg?!) but saved as arguments.
        if ("<" in name or ">" in name or "=" in name):
            if comparison_operation != parent:
                instance = construct_argument("operation", data, node_type, parent, is_executable, is_optional, redirect_class, type="String")
                comparison_operation = parent
        else:
            instance = construct_literal(name, data, node_type, parent, is_executable, is_optional, redirect_class, literal_name)
    else:
        instance = construct_argument(name, data, node_type, parent, is_executable, is_optional, redirect_class, type="Float")

    if instance is None:
        return None

    # Add 1 to the executable amount if the node is executable.
    if is_executable:
        executable += 1

    return instance, redirect_class


def main():
    global opened_file

    # Delete files first.
    for item in os.listdir("."):
        if item.endswith(EXTENSION):
            os.remove(item)

    # Load command.json.
    with open("commands.json", "r") as registry:
        command = json.load(registry)

    # Iterate over the nodes.
    try:
        iterate_children("root", command)
    except Exception as e:
        print(traceback.format_exc())

        if opened_file is not None:
            opened_file.close()

        sys.exit(1)

    if opened_file is not None:
        opened_file.close()

main()