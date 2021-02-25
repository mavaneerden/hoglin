package command.baseclasses

abstract class CommandArgument(
    parent: CommandNode,
    argument: Any?
): CommandNode(parent, argument)