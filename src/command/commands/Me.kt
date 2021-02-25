package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootMeActionCommand(
    parent: CommandNode,
    action: String
): CommandArgument(parent, action)

class RootMeCommand(
    parent: CommandNode?,
    literal: String? = "me"
): CommandLiteral(parent, literal) {
    fun action(action: String): RootMeActionCommand {
        return RootMeActionCommand(this, action)
    }

    operator fun invoke(action: String): RootMeActionCommand {
        return action(action)
    }
}
val me = RootMeCommand(null)