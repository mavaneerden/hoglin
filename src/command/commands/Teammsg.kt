package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootTeammsgMessageCommand(
    parent: CommandNode,
    message: String
): CommandArgument(parent, message)

class RootTeammsgCommand(
    parent: CommandNode?,
    literal: String? = "teammsg"
): CommandLiteral(parent, literal) {
    fun message(message: String): RootTeammsgMessageCommand {
        return RootTeammsgMessageCommand(this, message)
    }

    operator fun invoke(message: String): RootTeammsgMessageCommand {
        return message(message)
    }
}
val teammsg = RootTeammsgCommand(null)