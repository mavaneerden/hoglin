package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootGiveTargetsItemCountCommand(
    parent: CommandNode,
    count: Int? = null
): CommandArgument(parent, count)

class RootGiveTargetsItemCommand(
    parent: CommandNode,
    item: String
): CommandArgument(parent, item) {
    fun count(count: Int? = null): RootGiveTargetsItemCountCommand {
        return RootGiveTargetsItemCountCommand(this, count)
    }
}

class RootGiveTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun item(item: String): RootGiveTargetsItemCommand {
        return RootGiveTargetsItemCommand(this, item)
    }
}

class RootGiveCommand(
    parent: CommandNode?,
    literal: String? = "give"
): CommandLiteral(parent, literal) {
    fun targets(targets: Selector): RootGiveTargetsCommand {
        return RootGiveTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, item: String, count: Int? = null): RootGiveTargetsItemCountCommand {
        return targets(targets).item(item).count(count)
    }
}
val give = RootGiveCommand(null)