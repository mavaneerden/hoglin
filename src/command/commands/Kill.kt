package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootKillTargetsCommand(
    parent: CommandNode,
    targets: Selector? = null
): CommandArgument(parent, targets)

class RootKillCommand(
    parent: CommandNode?,
    literal: String? = "kill"
): CommandLiteral(parent, literal) {
    fun targets(targets: Selector? = null): RootKillTargetsCommand {
        return RootKillTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector? = null): RootKillTargetsCommand {
        return targets(targets)
    }
}
val kill = RootKillCommand(null)