package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootFunctionNameCommand(
    parent: CommandNode,
    name: String
): CommandArgument(parent, name)

class RootFunctionCommand(
    parent: CommandNode?,
    literal: String? = "function"
): CommandLiteral(parent, literal) {
    fun name(name: String): RootFunctionNameCommand {
        return RootFunctionNameCommand(this, name)
    }

    operator fun invoke(name: String): RootFunctionNameCommand {
        return name(name)
    }
}
val function = RootFunctionCommand(null)