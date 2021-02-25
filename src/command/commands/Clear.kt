package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootClearTargetsItemMaxCountCommand(
    parent: CommandNode,
    maxCount: Int? = null
): CommandArgument(parent, maxCount)

class RootClearTargetsItemCommand(
    parent: CommandNode,
    item: String? = null
): CommandArgument(parent, item) {
    fun maxCount(maxCount: Int? = null): RootClearTargetsItemMaxCountCommand {
        return RootClearTargetsItemMaxCountCommand(this, maxCount)
    }
}

class RootClearTargetsCommand(
    parent: CommandNode,
    targets: Selector? = null
): CommandArgument(parent, targets) {
    fun item(item: String? = null): RootClearTargetsItemCommand {
        return RootClearTargetsItemCommand(this, item)
    }
}

class RootClearCommand(
    parent: CommandNode?,
    literal: String? = "clear"
): CommandLiteral(parent, literal) {
    fun targets(targets: Selector? = null): RootClearTargetsCommand {
        return RootClearTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector? = null, item: String? = null, maxCount: Int? = null): RootClearTargetsItemMaxCountCommand {
        return targets(targets).item(item).maxCount(maxCount)
    }
}
val clear = RootClearCommand(null)