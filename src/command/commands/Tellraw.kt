package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootTellrawTargetsMessageCommand(
    parent: CommandNode,
    message: String
): CommandArgument(parent, message)

class RootTellrawTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun message(message: String): RootTellrawTargetsMessageCommand {
        return RootTellrawTargetsMessageCommand(this, message)
    }
}

class RootTellrawCommand(
    parent: CommandNode?,
    literal: String? = "tellraw"
): CommandLiteral(parent, literal) {
    fun targets(targets: Selector): RootTellrawTargetsCommand {
        return RootTellrawTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, message: String): RootTellrawTargetsMessageCommand {
        return targets(targets).message(message)
    }
}
val tellraw = RootTellrawCommand(null)