package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootBanTargetsReasonCommand(
    parent: CommandNode,
    reason: String? = null
): CommandArgument(parent, reason)

class RootBanTargetsCommand(
    parent: CommandNode,
    targets: String
): CommandArgument(parent, targets) {
    fun reason(reason: String? = null): RootBanTargetsReasonCommand {
        return RootBanTargetsReasonCommand(this, reason)
    }
}

class RootBanCommand(
    parent: CommandNode?,
    literal: String? = "ban"
): CommandLiteral(parent, literal) {
    fun targets(targets: String): RootBanTargetsCommand {
        return RootBanTargetsCommand(this, targets)
    }

    operator fun invoke(targets: String, reason: String? = null): RootBanTargetsReasonCommand {
        return targets(targets).reason(reason)
    }
}
val ban = RootBanCommand(null)