package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootOpTargetsCommand(
    parent: CommandNode,
    targets: String
): CommandArgument(parent, targets)

class RootOpCommand(
    parent: CommandNode?,
    literal: String? = "op"
): CommandLiteral(parent, literal) {
    fun targets(targets: String): RootOpTargetsCommand {
        return RootOpTargetsCommand(this, targets)
    }

    operator fun invoke(targets: String): RootOpTargetsCommand {
        return targets(targets)
    }
}
val op = RootOpCommand(null)