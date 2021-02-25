package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootKickTargetsReasonCommand(
    parent: CommandNode,
    reason: String? = null
): CommandArgument(parent, reason)

class RootKickTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun reason(reason: String? = null): RootKickTargetsReasonCommand {
        return RootKickTargetsReasonCommand(this, reason)
    }
}

class RootKickCommand(
    parent: CommandNode?,
    literal: String? = "kick"
): CommandLiteral(parent, literal) {
    fun targets(targets: Selector): RootKickTargetsCommand {
        return RootKickTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, reason: String? = null): RootKickTargetsReasonCommand {
        return targets(targets).reason(reason)
    }
}
val kick = RootKickCommand(null)