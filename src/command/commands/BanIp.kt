package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootBanIpTargetReasonCommand(
    parent: CommandNode,
    reason: String? = null
): CommandArgument(parent, reason)

class RootBanIpTargetCommand(
    parent: CommandNode,
    target: String
): CommandArgument(parent, target) {
    fun reason(reason: String? = null): RootBanIpTargetReasonCommand {
        return RootBanIpTargetReasonCommand(this, reason)
    }
}

class RootBanIpCommand(
    parent: CommandNode?,
    literal: String? = "ban-ip"
): CommandLiteral(parent, literal) {
    fun target(target: String): RootBanIpTargetCommand {
        return RootBanIpTargetCommand(this, target)
    }

    operator fun invoke(target: String, reason: String? = null): RootBanIpTargetReasonCommand {
        return target(target).reason(reason)
    }
}
val banIp = RootBanIpCommand(null)