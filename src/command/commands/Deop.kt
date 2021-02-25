package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootDeopTargetsCommand(
    parent: CommandNode,
    targets: String
): CommandArgument(parent, targets)

class RootDeopCommand(
    parent: CommandNode?,
    literal: String? = "deop"
): CommandLiteral(parent, literal) {
    fun targets(targets: String): RootDeopTargetsCommand {
        return RootDeopTargetsCommand(this, targets)
    }

    operator fun invoke(targets: String): RootDeopTargetsCommand {
        return targets(targets)
    }
}
val deop = RootDeopCommand(null)