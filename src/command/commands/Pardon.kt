package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootPardonTargetsCommand(
    parent: CommandNode,
    targets: String
): CommandArgument(parent, targets)

class RootPardonCommand(
    parent: CommandNode?,
    literal: String? = "pardon"
): CommandLiteral(parent, literal) {
    fun targets(targets: String): RootPardonTargetsCommand {
        return RootPardonTargetsCommand(this, targets)
    }

    operator fun invoke(targets: String): RootPardonTargetsCommand {
        return targets(targets)
    }
}
val pardon = RootPardonCommand(null)