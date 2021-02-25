package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootPardonIpTargetCommand(
    parent: CommandNode,
    target: String
): CommandArgument(parent, target)

class RootPardonIpCommand(
    parent: CommandNode?,
    literal: String? = "pardon-ip"
): CommandLiteral(parent, literal) {
    fun target(target: String): RootPardonIpTargetCommand {
        return RootPardonIpTargetCommand(this, target)
    }

    operator fun invoke(target: String): RootPardonIpTargetCommand {
        return target(target)
    }
}
val pardonIp = RootPardonIpCommand(null)