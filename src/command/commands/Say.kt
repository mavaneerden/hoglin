package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootSayMessageCommand(
    parent: CommandNode,
    message: String
): CommandArgument(parent, message)

class RootSayCommand(
    parent: CommandNode?,
    literal: String? = "say"
): CommandLiteral(parent, literal) {
    fun message(message: String): RootSayMessageCommand {
        return RootSayMessageCommand(this, message)
    }

    operator fun invoke(message: String): RootSayMessageCommand {
        return message(message)
    }
}
val say = RootSayCommand(null)