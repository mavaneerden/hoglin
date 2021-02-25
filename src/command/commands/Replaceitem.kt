package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootReplaceitemBlockPosSlotItemCountCommand(
    parent: CommandNode,
    count: Int? = null
): CommandArgument(parent, count)

class RootReplaceitemBlockPosSlotItemCommand(
    parent: CommandNode,
    item: String
): CommandArgument(parent, item) {
    fun count(count: Int? = null): RootReplaceitemBlockPosSlotItemCountCommand {
        return RootReplaceitemBlockPosSlotItemCountCommand(this, count)
    }
}

class RootReplaceitemBlockPosSlotCommand(
    parent: CommandNode,
    slot: String
): CommandArgument(parent, slot) {
    fun item(item: String): RootReplaceitemBlockPosSlotItemCommand {
        return RootReplaceitemBlockPosSlotItemCommand(this, item)
    }
}

class RootReplaceitemBlockPosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    fun slot(slot: String): RootReplaceitemBlockPosSlotCommand {
        return RootReplaceitemBlockPosSlotCommand(this, slot)
    }
}

class RootReplaceitemBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun pos(pos: String): RootReplaceitemBlockPosCommand {
        return RootReplaceitemBlockPosCommand(this, pos)
    }

    operator fun invoke(pos: String, slot: String, item: String, count: Int? = null): RootReplaceitemBlockPosSlotItemCountCommand {
        return pos(pos).slot(slot).item(item).count(count)
    }
}

class RootReplaceitemEntityTargetsSlotItemCountCommand(
    parent: CommandNode,
    count: Int? = null
): CommandArgument(parent, count)

class RootReplaceitemEntityTargetsSlotItemCommand(
    parent: CommandNode,
    item: String
): CommandArgument(parent, item) {
    fun count(count: Int? = null): RootReplaceitemEntityTargetsSlotItemCountCommand {
        return RootReplaceitemEntityTargetsSlotItemCountCommand(this, count)
    }
}

class RootReplaceitemEntityTargetsSlotCommand(
    parent: CommandNode,
    slot: String
): CommandArgument(parent, slot) {
    fun item(item: String): RootReplaceitemEntityTargetsSlotItemCommand {
        return RootReplaceitemEntityTargetsSlotItemCommand(this, item)
    }
}

class RootReplaceitemEntityTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun slot(slot: String): RootReplaceitemEntityTargetsSlotCommand {
        return RootReplaceitemEntityTargetsSlotCommand(this, slot)
    }
}

class RootReplaceitemEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun targets(targets: Selector): RootReplaceitemEntityTargetsCommand {
        return RootReplaceitemEntityTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, slot: String, item: String, count: Int? = null): RootReplaceitemEntityTargetsSlotItemCountCommand {
        return targets(targets).slot(slot).item(item).count(count)
    }
}

class RootReplaceitemCommand(
    parent: CommandNode?,
    literal: String? = "replaceitem"
): CommandLiteral(parent, literal) {
    val block = RootReplaceitemBlockCommand(this)
    val entity = RootReplaceitemEntityCommand(this)
}
val replaceitem = RootReplaceitemCommand(null)