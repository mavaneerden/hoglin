package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootLootGivePlayersFishLootTablePosMainhandCommand(
    parent: CommandNode,
    literal: String? = "mainhand"
): CommandLiteral(parent, literal)

class RootLootGivePlayersFishLootTablePosOffhandCommand(
    parent: CommandNode,
    literal: String? = "offhand"
): CommandLiteral(parent, literal)

class RootLootGivePlayersFishLootTablePosToolCommand(
    parent: CommandNode,
    tool: String? = null
): CommandArgument(parent, tool)

class RootLootGivePlayersFishLootTablePosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    val mainhand = RootLootGivePlayersFishLootTablePosMainhandCommand(this)
    val offhand = RootLootGivePlayersFishLootTablePosOffhandCommand(this)

        fun tool(tool: String? = null): RootLootGivePlayersFishLootTablePosToolCommand {
        return RootLootGivePlayersFishLootTablePosToolCommand(this, tool)
    }
}

class RootLootGivePlayersFishLootTableCommand(
    parent: CommandNode,
    lootTable: String
): CommandArgument(parent, lootTable) {
    fun pos(pos: String): RootLootGivePlayersFishLootTablePosCommand {
        return RootLootGivePlayersFishLootTablePosCommand(this, pos)
    }
}

class RootLootGivePlayersFishCommand(
    parent: CommandNode
): CommandLiteral(parent, "fish") {
    fun lootTable(lootTable: String): RootLootGivePlayersFishLootTableCommand {
        return RootLootGivePlayersFishLootTableCommand(this, lootTable)
    }

    operator fun invoke(lootTable: String, pos: String): RootLootGivePlayersFishLootTablePosCommand {
        return lootTable(lootTable).pos(pos)
    }

    operator fun invoke(lootTable: String, pos: String, tool: String? = null): RootLootGivePlayersFishLootTablePosToolCommand {
        return lootTable(lootTable).pos(pos).tool(tool)
    }
}

class RootLootGivePlayersKillTargetCommand(
    parent: CommandNode,
    target: Selector
): CommandArgument(parent, target)

class RootLootGivePlayersKillCommand(
    parent: CommandNode
): CommandLiteral(parent, "kill") {
    fun target(target: Selector): RootLootGivePlayersKillTargetCommand {
        return RootLootGivePlayersKillTargetCommand(this, target)
    }

    operator fun invoke(target: Selector): RootLootGivePlayersKillTargetCommand {
        return target(target)
    }
}

class RootLootGivePlayersLootLootTableCommand(
    parent: CommandNode,
    lootTable: String
): CommandArgument(parent, lootTable)

class RootLootGivePlayersLootCommand(
    parent: CommandNode
): CommandLiteral(parent, "loot") {
    fun lootTable(lootTable: String): RootLootGivePlayersLootLootTableCommand {
        return RootLootGivePlayersLootLootTableCommand(this, lootTable)
    }

    operator fun invoke(lootTable: String): RootLootGivePlayersLootLootTableCommand {
        return lootTable(lootTable)
    }
}

class RootLootGivePlayersMinePosMainhandCommand(
    parent: CommandNode,
    literal: String? = "mainhand"
): CommandLiteral(parent, literal)

class RootLootGivePlayersMinePosOffhandCommand(
    parent: CommandNode,
    literal: String? = "offhand"
): CommandLiteral(parent, literal)

class RootLootGivePlayersMinePosToolCommand(
    parent: CommandNode,
    tool: String? = null
): CommandArgument(parent, tool)

class RootLootGivePlayersMinePosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    val mainhand = RootLootGivePlayersMinePosMainhandCommand(this)
    val offhand = RootLootGivePlayersMinePosOffhandCommand(this)

        fun tool(tool: String? = null): RootLootGivePlayersMinePosToolCommand {
        return RootLootGivePlayersMinePosToolCommand(this, tool)
    }
}

class RootLootGivePlayersMineCommand(
    parent: CommandNode
): CommandLiteral(parent, "mine") {
    fun pos(pos: String): RootLootGivePlayersMinePosCommand {
        return RootLootGivePlayersMinePosCommand(this, pos)
    }

    operator fun invoke(pos: String): RootLootGivePlayersMinePosCommand {
        return pos(pos)
    }

    operator fun invoke(pos: String, tool: String? = null): RootLootGivePlayersMinePosToolCommand {
        return pos(pos).tool(tool)
    }
}

class RootLootGivePlayersCommand(
    parent: CommandNode,
    players: Selector
): CommandArgument(parent, players) {
    val fish = RootLootGivePlayersFishCommand(this)
    val kill = RootLootGivePlayersKillCommand(this)
    val loot = RootLootGivePlayersLootCommand(this)
    val mine = RootLootGivePlayersMineCommand(this)
}

class RootLootGiveCommand(
    parent: CommandNode
): CommandLiteral(parent, "give") {
    fun players(players: Selector): RootLootGivePlayersCommand {
        return RootLootGivePlayersCommand(this, players)
    }

    operator fun invoke(players: Selector): RootLootGivePlayersCommand {
        return players(players)
    }
}

class RootLootInsertTargetPosFishLootTablePosMainhandCommand(
    parent: CommandNode,
    literal: String? = "mainhand"
): CommandLiteral(parent, literal)

class RootLootInsertTargetPosFishLootTablePosOffhandCommand(
    parent: CommandNode,
    literal: String? = "offhand"
): CommandLiteral(parent, literal)

class RootLootInsertTargetPosFishLootTablePosToolCommand(
    parent: CommandNode,
    tool: String? = null
): CommandArgument(parent, tool)

class RootLootInsertTargetPosFishLootTablePosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    val mainhand = RootLootInsertTargetPosFishLootTablePosMainhandCommand(this)
    val offhand = RootLootInsertTargetPosFishLootTablePosOffhandCommand(this)

        fun tool(tool: String? = null): RootLootInsertTargetPosFishLootTablePosToolCommand {
        return RootLootInsertTargetPosFishLootTablePosToolCommand(this, tool)
    }
}

class RootLootInsertTargetPosFishLootTableCommand(
    parent: CommandNode,
    lootTable: String
): CommandArgument(parent, lootTable) {
    fun pos(pos: String): RootLootInsertTargetPosFishLootTablePosCommand {
        return RootLootInsertTargetPosFishLootTablePosCommand(this, pos)
    }
}

class RootLootInsertTargetPosFishCommand(
    parent: CommandNode
): CommandLiteral(parent, "fish") {
    fun lootTable(lootTable: String): RootLootInsertTargetPosFishLootTableCommand {
        return RootLootInsertTargetPosFishLootTableCommand(this, lootTable)
    }

    operator fun invoke(lootTable: String, pos: String): RootLootInsertTargetPosFishLootTablePosCommand {
        return lootTable(lootTable).pos(pos)
    }

    operator fun invoke(lootTable: String, pos: String, tool: String? = null): RootLootInsertTargetPosFishLootTablePosToolCommand {
        return lootTable(lootTable).pos(pos).tool(tool)
    }
}

class RootLootInsertTargetPosKillTargetCommand(
    parent: CommandNode,
    target: Selector
): CommandArgument(parent, target)

class RootLootInsertTargetPosKillCommand(
    parent: CommandNode
): CommandLiteral(parent, "kill") {
    fun target(target: Selector): RootLootInsertTargetPosKillTargetCommand {
        return RootLootInsertTargetPosKillTargetCommand(this, target)
    }

    operator fun invoke(target: Selector): RootLootInsertTargetPosKillTargetCommand {
        return target(target)
    }
}

class RootLootInsertTargetPosLootLootTableCommand(
    parent: CommandNode,
    lootTable: String
): CommandArgument(parent, lootTable)

class RootLootInsertTargetPosLootCommand(
    parent: CommandNode
): CommandLiteral(parent, "loot") {
    fun lootTable(lootTable: String): RootLootInsertTargetPosLootLootTableCommand {
        return RootLootInsertTargetPosLootLootTableCommand(this, lootTable)
    }

    operator fun invoke(lootTable: String): RootLootInsertTargetPosLootLootTableCommand {
        return lootTable(lootTable)
    }
}

class RootLootInsertTargetPosMinePosMainhandCommand(
    parent: CommandNode,
    literal: String? = "mainhand"
): CommandLiteral(parent, literal)

class RootLootInsertTargetPosMinePosOffhandCommand(
    parent: CommandNode,
    literal: String? = "offhand"
): CommandLiteral(parent, literal)

class RootLootInsertTargetPosMinePosToolCommand(
    parent: CommandNode,
    tool: String? = null
): CommandArgument(parent, tool)

class RootLootInsertTargetPosMinePosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    val mainhand = RootLootInsertTargetPosMinePosMainhandCommand(this)
    val offhand = RootLootInsertTargetPosMinePosOffhandCommand(this)

        fun tool(tool: String? = null): RootLootInsertTargetPosMinePosToolCommand {
        return RootLootInsertTargetPosMinePosToolCommand(this, tool)
    }
}

class RootLootInsertTargetPosMineCommand(
    parent: CommandNode
): CommandLiteral(parent, "mine") {
    fun pos(pos: String): RootLootInsertTargetPosMinePosCommand {
        return RootLootInsertTargetPosMinePosCommand(this, pos)
    }

    operator fun invoke(pos: String): RootLootInsertTargetPosMinePosCommand {
        return pos(pos)
    }

    operator fun invoke(pos: String, tool: String? = null): RootLootInsertTargetPosMinePosToolCommand {
        return pos(pos).tool(tool)
    }
}

class RootLootInsertTargetPosCommand(
    parent: CommandNode,
    targetPos: String
): CommandArgument(parent, targetPos) {
    val fish = RootLootInsertTargetPosFishCommand(this)
    val kill = RootLootInsertTargetPosKillCommand(this)
    val loot = RootLootInsertTargetPosLootCommand(this)
    val mine = RootLootInsertTargetPosMineCommand(this)
}

class RootLootInsertCommand(
    parent: CommandNode
): CommandLiteral(parent, "insert") {
    fun targetPos(targetPos: String): RootLootInsertTargetPosCommand {
        return RootLootInsertTargetPosCommand(this, targetPos)
    }

    operator fun invoke(targetPos: String): RootLootInsertTargetPosCommand {
        return targetPos(targetPos)
    }
}

class RootLootReplaceBlockTargetPosSlotFishLootTablePosMainhandCommand(
    parent: CommandNode,
    literal: String? = "mainhand"
): CommandLiteral(parent, literal)

class RootLootReplaceBlockTargetPosSlotFishLootTablePosOffhandCommand(
    parent: CommandNode,
    literal: String? = "offhand"
): CommandLiteral(parent, literal)

class RootLootReplaceBlockTargetPosSlotFishLootTablePosToolCommand(
    parent: CommandNode,
    tool: String? = null
): CommandArgument(parent, tool)

class RootLootReplaceBlockTargetPosSlotFishLootTablePosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    val mainhand = RootLootReplaceBlockTargetPosSlotFishLootTablePosMainhandCommand(this)
    val offhand = RootLootReplaceBlockTargetPosSlotFishLootTablePosOffhandCommand(this)

        fun tool(tool: String? = null): RootLootReplaceBlockTargetPosSlotFishLootTablePosToolCommand {
        return RootLootReplaceBlockTargetPosSlotFishLootTablePosToolCommand(this, tool)
    }
}

class RootLootReplaceBlockTargetPosSlotFishLootTableCommand(
    parent: CommandNode,
    lootTable: String
): CommandArgument(parent, lootTable) {
    fun pos(pos: String): RootLootReplaceBlockTargetPosSlotFishLootTablePosCommand {
        return RootLootReplaceBlockTargetPosSlotFishLootTablePosCommand(this, pos)
    }
}

class RootLootReplaceBlockTargetPosSlotFishCommand(
    parent: CommandNode
): CommandLiteral(parent, "fish") {
    fun lootTable(lootTable: String): RootLootReplaceBlockTargetPosSlotFishLootTableCommand {
        return RootLootReplaceBlockTargetPosSlotFishLootTableCommand(this, lootTable)
    }

    operator fun invoke(lootTable: String, pos: String): RootLootReplaceBlockTargetPosSlotFishLootTablePosCommand {
        return lootTable(lootTable).pos(pos)
    }

    operator fun invoke(lootTable: String, pos: String, tool: String? = null): RootLootReplaceBlockTargetPosSlotFishLootTablePosToolCommand {
        return lootTable(lootTable).pos(pos).tool(tool)
    }
}

class RootLootReplaceBlockTargetPosSlotKillTargetCommand(
    parent: CommandNode,
    target: Selector
): CommandArgument(parent, target)

class RootLootReplaceBlockTargetPosSlotKillCommand(
    parent: CommandNode
): CommandLiteral(parent, "kill") {
    fun target(target: Selector): RootLootReplaceBlockTargetPosSlotKillTargetCommand {
        return RootLootReplaceBlockTargetPosSlotKillTargetCommand(this, target)
    }

    operator fun invoke(target: Selector): RootLootReplaceBlockTargetPosSlotKillTargetCommand {
        return target(target)
    }
}

class RootLootReplaceBlockTargetPosSlotLootLootTableCommand(
    parent: CommandNode,
    lootTable: String
): CommandArgument(parent, lootTable)

class RootLootReplaceBlockTargetPosSlotLootCommand(
    parent: CommandNode
): CommandLiteral(parent, "loot") {
    fun lootTable(lootTable: String): RootLootReplaceBlockTargetPosSlotLootLootTableCommand {
        return RootLootReplaceBlockTargetPosSlotLootLootTableCommand(this, lootTable)
    }

    operator fun invoke(lootTable: String): RootLootReplaceBlockTargetPosSlotLootLootTableCommand {
        return lootTable(lootTable)
    }
}

class RootLootReplaceBlockTargetPosSlotMinePosMainhandCommand(
    parent: CommandNode,
    literal: String? = "mainhand"
): CommandLiteral(parent, literal)

class RootLootReplaceBlockTargetPosSlotMinePosOffhandCommand(
    parent: CommandNode,
    literal: String? = "offhand"
): CommandLiteral(parent, literal)

class RootLootReplaceBlockTargetPosSlotMinePosToolCommand(
    parent: CommandNode,
    tool: String? = null
): CommandArgument(parent, tool)

class RootLootReplaceBlockTargetPosSlotMinePosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    val mainhand = RootLootReplaceBlockTargetPosSlotMinePosMainhandCommand(this)
    val offhand = RootLootReplaceBlockTargetPosSlotMinePosOffhandCommand(this)

        fun tool(tool: String? = null): RootLootReplaceBlockTargetPosSlotMinePosToolCommand {
        return RootLootReplaceBlockTargetPosSlotMinePosToolCommand(this, tool)
    }
}

class RootLootReplaceBlockTargetPosSlotMineCommand(
    parent: CommandNode
): CommandLiteral(parent, "mine") {
    fun pos(pos: String): RootLootReplaceBlockTargetPosSlotMinePosCommand {
        return RootLootReplaceBlockTargetPosSlotMinePosCommand(this, pos)
    }

    operator fun invoke(pos: String): RootLootReplaceBlockTargetPosSlotMinePosCommand {
        return pos(pos)
    }

    operator fun invoke(pos: String, tool: String? = null): RootLootReplaceBlockTargetPosSlotMinePosToolCommand {
        return pos(pos).tool(tool)
    }
}

class RootLootReplaceBlockTargetPosSlotCountFishLootTablePosMainhandCommand(
    parent: CommandNode,
    literal: String? = "mainhand"
): CommandLiteral(parent, literal)

class RootLootReplaceBlockTargetPosSlotCountFishLootTablePosOffhandCommand(
    parent: CommandNode,
    literal: String? = "offhand"
): CommandLiteral(parent, literal)

class RootLootReplaceBlockTargetPosSlotCountFishLootTablePosToolCommand(
    parent: CommandNode,
    tool: String? = null
): CommandArgument(parent, tool)

class RootLootReplaceBlockTargetPosSlotCountFishLootTablePosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    val mainhand = RootLootReplaceBlockTargetPosSlotCountFishLootTablePosMainhandCommand(this)
    val offhand = RootLootReplaceBlockTargetPosSlotCountFishLootTablePosOffhandCommand(this)

        fun tool(tool: String? = null): RootLootReplaceBlockTargetPosSlotCountFishLootTablePosToolCommand {
        return RootLootReplaceBlockTargetPosSlotCountFishLootTablePosToolCommand(this, tool)
    }
}

class RootLootReplaceBlockTargetPosSlotCountFishLootTableCommand(
    parent: CommandNode,
    lootTable: String
): CommandArgument(parent, lootTable) {
    fun pos(pos: String): RootLootReplaceBlockTargetPosSlotCountFishLootTablePosCommand {
        return RootLootReplaceBlockTargetPosSlotCountFishLootTablePosCommand(this, pos)
    }
}

class RootLootReplaceBlockTargetPosSlotCountFishCommand(
    parent: CommandNode
): CommandLiteral(parent, "fish") {
    fun lootTable(lootTable: String): RootLootReplaceBlockTargetPosSlotCountFishLootTableCommand {
        return RootLootReplaceBlockTargetPosSlotCountFishLootTableCommand(this, lootTable)
    }

    operator fun invoke(lootTable: String, pos: String): RootLootReplaceBlockTargetPosSlotCountFishLootTablePosCommand {
        return lootTable(lootTable).pos(pos)
    }

    operator fun invoke(lootTable: String, pos: String, tool: String? = null): RootLootReplaceBlockTargetPosSlotCountFishLootTablePosToolCommand {
        return lootTable(lootTable).pos(pos).tool(tool)
    }
}

class RootLootReplaceBlockTargetPosSlotCountKillTargetCommand(
    parent: CommandNode,
    target: Selector
): CommandArgument(parent, target)

class RootLootReplaceBlockTargetPosSlotCountKillCommand(
    parent: CommandNode
): CommandLiteral(parent, "kill") {
    fun target(target: Selector): RootLootReplaceBlockTargetPosSlotCountKillTargetCommand {
        return RootLootReplaceBlockTargetPosSlotCountKillTargetCommand(this, target)
    }

    operator fun invoke(target: Selector): RootLootReplaceBlockTargetPosSlotCountKillTargetCommand {
        return target(target)
    }
}

class RootLootReplaceBlockTargetPosSlotCountLootLootTableCommand(
    parent: CommandNode,
    lootTable: String
): CommandArgument(parent, lootTable)

class RootLootReplaceBlockTargetPosSlotCountLootCommand(
    parent: CommandNode
): CommandLiteral(parent, "loot") {
    fun lootTable(lootTable: String): RootLootReplaceBlockTargetPosSlotCountLootLootTableCommand {
        return RootLootReplaceBlockTargetPosSlotCountLootLootTableCommand(this, lootTable)
    }

    operator fun invoke(lootTable: String): RootLootReplaceBlockTargetPosSlotCountLootLootTableCommand {
        return lootTable(lootTable)
    }
}

class RootLootReplaceBlockTargetPosSlotCountMinePosMainhandCommand(
    parent: CommandNode,
    literal: String? = "mainhand"
): CommandLiteral(parent, literal)

class RootLootReplaceBlockTargetPosSlotCountMinePosOffhandCommand(
    parent: CommandNode,
    literal: String? = "offhand"
): CommandLiteral(parent, literal)

class RootLootReplaceBlockTargetPosSlotCountMinePosToolCommand(
    parent: CommandNode,
    tool: String? = null
): CommandArgument(parent, tool)

class RootLootReplaceBlockTargetPosSlotCountMinePosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    val mainhand = RootLootReplaceBlockTargetPosSlotCountMinePosMainhandCommand(this)
    val offhand = RootLootReplaceBlockTargetPosSlotCountMinePosOffhandCommand(this)

        fun tool(tool: String? = null): RootLootReplaceBlockTargetPosSlotCountMinePosToolCommand {
        return RootLootReplaceBlockTargetPosSlotCountMinePosToolCommand(this, tool)
    }
}

class RootLootReplaceBlockTargetPosSlotCountMineCommand(
    parent: CommandNode
): CommandLiteral(parent, "mine") {
    fun pos(pos: String): RootLootReplaceBlockTargetPosSlotCountMinePosCommand {
        return RootLootReplaceBlockTargetPosSlotCountMinePosCommand(this, pos)
    }

    operator fun invoke(pos: String): RootLootReplaceBlockTargetPosSlotCountMinePosCommand {
        return pos(pos)
    }

    operator fun invoke(pos: String, tool: String? = null): RootLootReplaceBlockTargetPosSlotCountMinePosToolCommand {
        return pos(pos).tool(tool)
    }
}

class RootLootReplaceBlockTargetPosSlotCountCommand(
    parent: CommandNode,
    count: Int
): CommandArgument(parent, count) {
    val fish = RootLootReplaceBlockTargetPosSlotCountFishCommand(this)
    val kill = RootLootReplaceBlockTargetPosSlotCountKillCommand(this)
    val loot = RootLootReplaceBlockTargetPosSlotCountLootCommand(this)
    val mine = RootLootReplaceBlockTargetPosSlotCountMineCommand(this)
}

class RootLootReplaceBlockTargetPosSlotCommand(
    parent: CommandNode,
    slot: String
): CommandArgument(parent, slot) {
    val fish = RootLootReplaceBlockTargetPosSlotFishCommand(this)
    val kill = RootLootReplaceBlockTargetPosSlotKillCommand(this)
    val loot = RootLootReplaceBlockTargetPosSlotLootCommand(this)
    val mine = RootLootReplaceBlockTargetPosSlotMineCommand(this)

        fun count(count: Int): RootLootReplaceBlockTargetPosSlotCountCommand {
        return RootLootReplaceBlockTargetPosSlotCountCommand(this, count)
    }
}

class RootLootReplaceBlockTargetPosCommand(
    parent: CommandNode,
    targetPos: String
): CommandArgument(parent, targetPos) {
    fun slot(slot: String): RootLootReplaceBlockTargetPosSlotCommand {
        return RootLootReplaceBlockTargetPosSlotCommand(this, slot)
    }
}

class RootLootReplaceBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun targetPos(targetPos: String): RootLootReplaceBlockTargetPosCommand {
        return RootLootReplaceBlockTargetPosCommand(this, targetPos)
    }

    operator fun invoke(targetPos: String, slot: String): RootLootReplaceBlockTargetPosSlotCommand {
        return targetPos(targetPos).slot(slot)
    }

    operator fun invoke(targetPos: String, slot: String, count: Int): RootLootReplaceBlockTargetPosSlotCountCommand {
        return targetPos(targetPos).slot(slot).count(count)
    }
}

class RootLootReplaceEntityEntitiesSlotFishLootTablePosMainhandCommand(
    parent: CommandNode,
    literal: String? = "mainhand"
): CommandLiteral(parent, literal)

class RootLootReplaceEntityEntitiesSlotFishLootTablePosOffhandCommand(
    parent: CommandNode,
    literal: String? = "offhand"
): CommandLiteral(parent, literal)

class RootLootReplaceEntityEntitiesSlotFishLootTablePosToolCommand(
    parent: CommandNode,
    tool: String? = null
): CommandArgument(parent, tool)

class RootLootReplaceEntityEntitiesSlotFishLootTablePosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    val mainhand = RootLootReplaceEntityEntitiesSlotFishLootTablePosMainhandCommand(this)
    val offhand = RootLootReplaceEntityEntitiesSlotFishLootTablePosOffhandCommand(this)

        fun tool(tool: String? = null): RootLootReplaceEntityEntitiesSlotFishLootTablePosToolCommand {
        return RootLootReplaceEntityEntitiesSlotFishLootTablePosToolCommand(this, tool)
    }
}

class RootLootReplaceEntityEntitiesSlotFishLootTableCommand(
    parent: CommandNode,
    lootTable: String
): CommandArgument(parent, lootTable) {
    fun pos(pos: String): RootLootReplaceEntityEntitiesSlotFishLootTablePosCommand {
        return RootLootReplaceEntityEntitiesSlotFishLootTablePosCommand(this, pos)
    }
}

class RootLootReplaceEntityEntitiesSlotFishCommand(
    parent: CommandNode
): CommandLiteral(parent, "fish") {
    fun lootTable(lootTable: String): RootLootReplaceEntityEntitiesSlotFishLootTableCommand {
        return RootLootReplaceEntityEntitiesSlotFishLootTableCommand(this, lootTable)
    }

    operator fun invoke(lootTable: String, pos: String): RootLootReplaceEntityEntitiesSlotFishLootTablePosCommand {
        return lootTable(lootTable).pos(pos)
    }

    operator fun invoke(lootTable: String, pos: String, tool: String? = null): RootLootReplaceEntityEntitiesSlotFishLootTablePosToolCommand {
        return lootTable(lootTable).pos(pos).tool(tool)
    }
}

class RootLootReplaceEntityEntitiesSlotKillTargetCommand(
    parent: CommandNode,
    target: Selector
): CommandArgument(parent, target)

class RootLootReplaceEntityEntitiesSlotKillCommand(
    parent: CommandNode
): CommandLiteral(parent, "kill") {
    fun target(target: Selector): RootLootReplaceEntityEntitiesSlotKillTargetCommand {
        return RootLootReplaceEntityEntitiesSlotKillTargetCommand(this, target)
    }

    operator fun invoke(target: Selector): RootLootReplaceEntityEntitiesSlotKillTargetCommand {
        return target(target)
    }
}

class RootLootReplaceEntityEntitiesSlotLootLootTableCommand(
    parent: CommandNode,
    lootTable: String
): CommandArgument(parent, lootTable)

class RootLootReplaceEntityEntitiesSlotLootCommand(
    parent: CommandNode
): CommandLiteral(parent, "loot") {
    fun lootTable(lootTable: String): RootLootReplaceEntityEntitiesSlotLootLootTableCommand {
        return RootLootReplaceEntityEntitiesSlotLootLootTableCommand(this, lootTable)
    }

    operator fun invoke(lootTable: String): RootLootReplaceEntityEntitiesSlotLootLootTableCommand {
        return lootTable(lootTable)
    }
}

class RootLootReplaceEntityEntitiesSlotMinePosMainhandCommand(
    parent: CommandNode,
    literal: String? = "mainhand"
): CommandLiteral(parent, literal)

class RootLootReplaceEntityEntitiesSlotMinePosOffhandCommand(
    parent: CommandNode,
    literal: String? = "offhand"
): CommandLiteral(parent, literal)

class RootLootReplaceEntityEntitiesSlotMinePosToolCommand(
    parent: CommandNode,
    tool: String? = null
): CommandArgument(parent, tool)

class RootLootReplaceEntityEntitiesSlotMinePosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    val mainhand = RootLootReplaceEntityEntitiesSlotMinePosMainhandCommand(this)
    val offhand = RootLootReplaceEntityEntitiesSlotMinePosOffhandCommand(this)

        fun tool(tool: String? = null): RootLootReplaceEntityEntitiesSlotMinePosToolCommand {
        return RootLootReplaceEntityEntitiesSlotMinePosToolCommand(this, tool)
    }
}

class RootLootReplaceEntityEntitiesSlotMineCommand(
    parent: CommandNode
): CommandLiteral(parent, "mine") {
    fun pos(pos: String): RootLootReplaceEntityEntitiesSlotMinePosCommand {
        return RootLootReplaceEntityEntitiesSlotMinePosCommand(this, pos)
    }

    operator fun invoke(pos: String): RootLootReplaceEntityEntitiesSlotMinePosCommand {
        return pos(pos)
    }

    operator fun invoke(pos: String, tool: String? = null): RootLootReplaceEntityEntitiesSlotMinePosToolCommand {
        return pos(pos).tool(tool)
    }
}

class RootLootReplaceEntityEntitiesSlotCountFishLootTablePosMainhandCommand(
    parent: CommandNode,
    literal: String? = "mainhand"
): CommandLiteral(parent, literal)

class RootLootReplaceEntityEntitiesSlotCountFishLootTablePosOffhandCommand(
    parent: CommandNode,
    literal: String? = "offhand"
): CommandLiteral(parent, literal)

class RootLootReplaceEntityEntitiesSlotCountFishLootTablePosToolCommand(
    parent: CommandNode,
    tool: String? = null
): CommandArgument(parent, tool)

class RootLootReplaceEntityEntitiesSlotCountFishLootTablePosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    val mainhand = RootLootReplaceEntityEntitiesSlotCountFishLootTablePosMainhandCommand(this)
    val offhand = RootLootReplaceEntityEntitiesSlotCountFishLootTablePosOffhandCommand(this)

        fun tool(tool: String? = null): RootLootReplaceEntityEntitiesSlotCountFishLootTablePosToolCommand {
        return RootLootReplaceEntityEntitiesSlotCountFishLootTablePosToolCommand(this, tool)
    }
}

class RootLootReplaceEntityEntitiesSlotCountFishLootTableCommand(
    parent: CommandNode,
    lootTable: String
): CommandArgument(parent, lootTable) {
    fun pos(pos: String): RootLootReplaceEntityEntitiesSlotCountFishLootTablePosCommand {
        return RootLootReplaceEntityEntitiesSlotCountFishLootTablePosCommand(this, pos)
    }
}

class RootLootReplaceEntityEntitiesSlotCountFishCommand(
    parent: CommandNode
): CommandLiteral(parent, "fish") {
    fun lootTable(lootTable: String): RootLootReplaceEntityEntitiesSlotCountFishLootTableCommand {
        return RootLootReplaceEntityEntitiesSlotCountFishLootTableCommand(this, lootTable)
    }

    operator fun invoke(lootTable: String, pos: String): RootLootReplaceEntityEntitiesSlotCountFishLootTablePosCommand {
        return lootTable(lootTable).pos(pos)
    }

    operator fun invoke(lootTable: String, pos: String, tool: String? = null): RootLootReplaceEntityEntitiesSlotCountFishLootTablePosToolCommand {
        return lootTable(lootTable).pos(pos).tool(tool)
    }
}

class RootLootReplaceEntityEntitiesSlotCountKillTargetCommand(
    parent: CommandNode,
    target: Selector
): CommandArgument(parent, target)

class RootLootReplaceEntityEntitiesSlotCountKillCommand(
    parent: CommandNode
): CommandLiteral(parent, "kill") {
    fun target(target: Selector): RootLootReplaceEntityEntitiesSlotCountKillTargetCommand {
        return RootLootReplaceEntityEntitiesSlotCountKillTargetCommand(this, target)
    }

    operator fun invoke(target: Selector): RootLootReplaceEntityEntitiesSlotCountKillTargetCommand {
        return target(target)
    }
}

class RootLootReplaceEntityEntitiesSlotCountLootLootTableCommand(
    parent: CommandNode,
    lootTable: String
): CommandArgument(parent, lootTable)

class RootLootReplaceEntityEntitiesSlotCountLootCommand(
    parent: CommandNode
): CommandLiteral(parent, "loot") {
    fun lootTable(lootTable: String): RootLootReplaceEntityEntitiesSlotCountLootLootTableCommand {
        return RootLootReplaceEntityEntitiesSlotCountLootLootTableCommand(this, lootTable)
    }

    operator fun invoke(lootTable: String): RootLootReplaceEntityEntitiesSlotCountLootLootTableCommand {
        return lootTable(lootTable)
    }
}

class RootLootReplaceEntityEntitiesSlotCountMinePosMainhandCommand(
    parent: CommandNode,
    literal: String? = "mainhand"
): CommandLiteral(parent, literal)

class RootLootReplaceEntityEntitiesSlotCountMinePosOffhandCommand(
    parent: CommandNode,
    literal: String? = "offhand"
): CommandLiteral(parent, literal)

class RootLootReplaceEntityEntitiesSlotCountMinePosToolCommand(
    parent: CommandNode,
    tool: String? = null
): CommandArgument(parent, tool)

class RootLootReplaceEntityEntitiesSlotCountMinePosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    val mainhand = RootLootReplaceEntityEntitiesSlotCountMinePosMainhandCommand(this)
    val offhand = RootLootReplaceEntityEntitiesSlotCountMinePosOffhandCommand(this)

        fun tool(tool: String? = null): RootLootReplaceEntityEntitiesSlotCountMinePosToolCommand {
        return RootLootReplaceEntityEntitiesSlotCountMinePosToolCommand(this, tool)
    }
}

class RootLootReplaceEntityEntitiesSlotCountMineCommand(
    parent: CommandNode
): CommandLiteral(parent, "mine") {
    fun pos(pos: String): RootLootReplaceEntityEntitiesSlotCountMinePosCommand {
        return RootLootReplaceEntityEntitiesSlotCountMinePosCommand(this, pos)
    }

    operator fun invoke(pos: String): RootLootReplaceEntityEntitiesSlotCountMinePosCommand {
        return pos(pos)
    }

    operator fun invoke(pos: String, tool: String? = null): RootLootReplaceEntityEntitiesSlotCountMinePosToolCommand {
        return pos(pos).tool(tool)
    }
}

class RootLootReplaceEntityEntitiesSlotCountCommand(
    parent: CommandNode,
    count: Int
): CommandArgument(parent, count) {
    val fish = RootLootReplaceEntityEntitiesSlotCountFishCommand(this)
    val kill = RootLootReplaceEntityEntitiesSlotCountKillCommand(this)
    val loot = RootLootReplaceEntityEntitiesSlotCountLootCommand(this)
    val mine = RootLootReplaceEntityEntitiesSlotCountMineCommand(this)
}

class RootLootReplaceEntityEntitiesSlotCommand(
    parent: CommandNode,
    slot: String
): CommandArgument(parent, slot) {
    val fish = RootLootReplaceEntityEntitiesSlotFishCommand(this)
    val kill = RootLootReplaceEntityEntitiesSlotKillCommand(this)
    val loot = RootLootReplaceEntityEntitiesSlotLootCommand(this)
    val mine = RootLootReplaceEntityEntitiesSlotMineCommand(this)

        fun count(count: Int): RootLootReplaceEntityEntitiesSlotCountCommand {
        return RootLootReplaceEntityEntitiesSlotCountCommand(this, count)
    }
}

class RootLootReplaceEntityEntitiesCommand(
    parent: CommandNode,
    entities: Selector
): CommandArgument(parent, entities) {
    fun slot(slot: String): RootLootReplaceEntityEntitiesSlotCommand {
        return RootLootReplaceEntityEntitiesSlotCommand(this, slot)
    }
}

class RootLootReplaceEntityCommand(
    parent: CommandNode
): CommandLiteral(parent, "entity") {
    fun entities(entities: Selector): RootLootReplaceEntityEntitiesCommand {
        return RootLootReplaceEntityEntitiesCommand(this, entities)
    }

    operator fun invoke(entities: Selector, slot: String): RootLootReplaceEntityEntitiesSlotCommand {
        return entities(entities).slot(slot)
    }

    operator fun invoke(entities: Selector, slot: String, count: Int): RootLootReplaceEntityEntitiesSlotCountCommand {
        return entities(entities).slot(slot).count(count)
    }
}

class RootLootReplaceCommand(
    parent: CommandNode
): CommandLiteral(parent, "replace") {
    val block = RootLootReplaceBlockCommand(this)
    val entity = RootLootReplaceEntityCommand(this)
}

class RootLootSpawnTargetPosFishLootTablePosMainhandCommand(
    parent: CommandNode,
    literal: String? = "mainhand"
): CommandLiteral(parent, literal)

class RootLootSpawnTargetPosFishLootTablePosOffhandCommand(
    parent: CommandNode,
    literal: String? = "offhand"
): CommandLiteral(parent, literal)

class RootLootSpawnTargetPosFishLootTablePosToolCommand(
    parent: CommandNode,
    tool: String? = null
): CommandArgument(parent, tool)

class RootLootSpawnTargetPosFishLootTablePosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    val mainhand = RootLootSpawnTargetPosFishLootTablePosMainhandCommand(this)
    val offhand = RootLootSpawnTargetPosFishLootTablePosOffhandCommand(this)

        fun tool(tool: String? = null): RootLootSpawnTargetPosFishLootTablePosToolCommand {
        return RootLootSpawnTargetPosFishLootTablePosToolCommand(this, tool)
    }
}

class RootLootSpawnTargetPosFishLootTableCommand(
    parent: CommandNode,
    lootTable: String
): CommandArgument(parent, lootTable) {
    fun pos(pos: String): RootLootSpawnTargetPosFishLootTablePosCommand {
        return RootLootSpawnTargetPosFishLootTablePosCommand(this, pos)
    }
}

class RootLootSpawnTargetPosFishCommand(
    parent: CommandNode
): CommandLiteral(parent, "fish") {
    fun lootTable(lootTable: String): RootLootSpawnTargetPosFishLootTableCommand {
        return RootLootSpawnTargetPosFishLootTableCommand(this, lootTable)
    }

    operator fun invoke(lootTable: String, pos: String): RootLootSpawnTargetPosFishLootTablePosCommand {
        return lootTable(lootTable).pos(pos)
    }

    operator fun invoke(lootTable: String, pos: String, tool: String? = null): RootLootSpawnTargetPosFishLootTablePosToolCommand {
        return lootTable(lootTable).pos(pos).tool(tool)
    }
}

class RootLootSpawnTargetPosKillTargetCommand(
    parent: CommandNode,
    target: Selector
): CommandArgument(parent, target)

class RootLootSpawnTargetPosKillCommand(
    parent: CommandNode
): CommandLiteral(parent, "kill") {
    fun target(target: Selector): RootLootSpawnTargetPosKillTargetCommand {
        return RootLootSpawnTargetPosKillTargetCommand(this, target)
    }

    operator fun invoke(target: Selector): RootLootSpawnTargetPosKillTargetCommand {
        return target(target)
    }
}

class RootLootSpawnTargetPosLootLootTableCommand(
    parent: CommandNode,
    lootTable: String
): CommandArgument(parent, lootTable)

class RootLootSpawnTargetPosLootCommand(
    parent: CommandNode
): CommandLiteral(parent, "loot") {
    fun lootTable(lootTable: String): RootLootSpawnTargetPosLootLootTableCommand {
        return RootLootSpawnTargetPosLootLootTableCommand(this, lootTable)
    }

    operator fun invoke(lootTable: String): RootLootSpawnTargetPosLootLootTableCommand {
        return lootTable(lootTable)
    }
}

class RootLootSpawnTargetPosMinePosMainhandCommand(
    parent: CommandNode,
    literal: String? = "mainhand"
): CommandLiteral(parent, literal)

class RootLootSpawnTargetPosMinePosOffhandCommand(
    parent: CommandNode,
    literal: String? = "offhand"
): CommandLiteral(parent, literal)

class RootLootSpawnTargetPosMinePosToolCommand(
    parent: CommandNode,
    tool: String? = null
): CommandArgument(parent, tool)

class RootLootSpawnTargetPosMinePosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    val mainhand = RootLootSpawnTargetPosMinePosMainhandCommand(this)
    val offhand = RootLootSpawnTargetPosMinePosOffhandCommand(this)

        fun tool(tool: String? = null): RootLootSpawnTargetPosMinePosToolCommand {
        return RootLootSpawnTargetPosMinePosToolCommand(this, tool)
    }
}

class RootLootSpawnTargetPosMineCommand(
    parent: CommandNode
): CommandLiteral(parent, "mine") {
    fun pos(pos: String): RootLootSpawnTargetPosMinePosCommand {
        return RootLootSpawnTargetPosMinePosCommand(this, pos)
    }

    operator fun invoke(pos: String): RootLootSpawnTargetPosMinePosCommand {
        return pos(pos)
    }

    operator fun invoke(pos: String, tool: String? = null): RootLootSpawnTargetPosMinePosToolCommand {
        return pos(pos).tool(tool)
    }
}

class RootLootSpawnTargetPosCommand(
    parent: CommandNode,
    targetPos: Coordinates
): CommandArgument(parent, targetPos) {
    val fish = RootLootSpawnTargetPosFishCommand(this)
    val kill = RootLootSpawnTargetPosKillCommand(this)
    val loot = RootLootSpawnTargetPosLootCommand(this)
    val mine = RootLootSpawnTargetPosMineCommand(this)
}

class RootLootSpawnCommand(
    parent: CommandNode
): CommandLiteral(parent, "spawn") {
    fun targetPos(targetPos: Coordinates): RootLootSpawnTargetPosCommand {
        return RootLootSpawnTargetPosCommand(this, targetPos)
    }

    operator fun invoke(targetPos: Coordinates): RootLootSpawnTargetPosCommand {
        return targetPos(targetPos)
    }
}

class RootLootCommand(
    parent: CommandNode?,
    literal: String? = "loot"
): CommandLiteral(parent, literal) {
    val give = RootLootGiveCommand(this)
    val insert = RootLootInsertCommand(this)
    val replace = RootLootReplaceCommand(this)
    val spawn = RootLootSpawnCommand(this)
}
val loot = RootLootCommand(null)