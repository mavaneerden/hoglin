package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootHelpCommandCommand(
    parent: CommandNode,
    command: String? = null
): CommandArgument(parent, command)

class RootHelpCommand(
    parent: CommandNode?,
    literal: String? = "help"
): CommandLiteral(parent, literal) {
    fun command(command: String? = null): RootHelpCommandCommand {
        return RootHelpCommandCommand(this, command)
    }

    operator fun invoke(command: String? = null): RootHelpCommandCommand {
        return command(command)
    }
}
val help = RootHelpCommand(null)