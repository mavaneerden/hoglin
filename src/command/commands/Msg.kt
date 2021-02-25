package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootMsgTargetsMessageCommand(
    parent: CommandNode,
    message: String
): CommandArgument(parent, message)

class RootMsgTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun message(message: String): RootMsgTargetsMessageCommand {
        return RootMsgTargetsMessageCommand(this, message)
    }
}

class RootMsgCommand(
    parent: CommandNode?,
    literal: String? = "msg"
): CommandLiteral(parent, literal) {
    fun targets(targets: Selector): RootMsgTargetsCommand {
        return RootMsgTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, message: String): RootMsgTargetsMessageCommand {
        return targets(targets).message(message)
    }
}
val msg = RootMsgCommand(null)