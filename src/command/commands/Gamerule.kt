package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootGameruleAnnounceAdvancementsValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleAnnounceAdvancementsCommand(
    parent: CommandNode
): CommandLiteral(parent, "announceAdvancements") {
    fun value(value: Boolean? = null): RootGameruleAnnounceAdvancementsValueCommand {
        return RootGameruleAnnounceAdvancementsValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleAnnounceAdvancementsValueCommand {
        return value(value)
    }
}

class RootGameruleCommandBlockOutputValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleCommandBlockOutputCommand(
    parent: CommandNode
): CommandLiteral(parent, "commandBlockOutput") {
    fun value(value: Boolean? = null): RootGameruleCommandBlockOutputValueCommand {
        return RootGameruleCommandBlockOutputValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleCommandBlockOutputValueCommand {
        return value(value)
    }
}

class RootGameruleDisableElytraMovementCheckValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleDisableElytraMovementCheckCommand(
    parent: CommandNode
): CommandLiteral(parent, "disableElytraMovementCheck") {
    fun value(value: Boolean? = null): RootGameruleDisableElytraMovementCheckValueCommand {
        return RootGameruleDisableElytraMovementCheckValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleDisableElytraMovementCheckValueCommand {
        return value(value)
    }
}

class RootGameruleDisableRaidsValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleDisableRaidsCommand(
    parent: CommandNode
): CommandLiteral(parent, "disableRaids") {
    fun value(value: Boolean? = null): RootGameruleDisableRaidsValueCommand {
        return RootGameruleDisableRaidsValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleDisableRaidsValueCommand {
        return value(value)
    }
}

class RootGameruleDoDaylightCycleValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleDoDaylightCycleCommand(
    parent: CommandNode
): CommandLiteral(parent, "doDaylightCycle") {
    fun value(value: Boolean? = null): RootGameruleDoDaylightCycleValueCommand {
        return RootGameruleDoDaylightCycleValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleDoDaylightCycleValueCommand {
        return value(value)
    }
}

class RootGameruleDoEntityDropsValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleDoEntityDropsCommand(
    parent: CommandNode
): CommandLiteral(parent, "doEntityDrops") {
    fun value(value: Boolean? = null): RootGameruleDoEntityDropsValueCommand {
        return RootGameruleDoEntityDropsValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleDoEntityDropsValueCommand {
        return value(value)
    }
}

class RootGameruleDoFireTickValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleDoFireTickCommand(
    parent: CommandNode
): CommandLiteral(parent, "doFireTick") {
    fun value(value: Boolean? = null): RootGameruleDoFireTickValueCommand {
        return RootGameruleDoFireTickValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleDoFireTickValueCommand {
        return value(value)
    }
}

class RootGameruleDoImmediateRespawnValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleDoImmediateRespawnCommand(
    parent: CommandNode
): CommandLiteral(parent, "doImmediateRespawn") {
    fun value(value: Boolean? = null): RootGameruleDoImmediateRespawnValueCommand {
        return RootGameruleDoImmediateRespawnValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleDoImmediateRespawnValueCommand {
        return value(value)
    }
}

class RootGameruleDoInsomniaValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleDoInsomniaCommand(
    parent: CommandNode
): CommandLiteral(parent, "doInsomnia") {
    fun value(value: Boolean? = null): RootGameruleDoInsomniaValueCommand {
        return RootGameruleDoInsomniaValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleDoInsomniaValueCommand {
        return value(value)
    }
}

class RootGameruleDoLimitedCraftingValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleDoLimitedCraftingCommand(
    parent: CommandNode
): CommandLiteral(parent, "doLimitedCrafting") {
    fun value(value: Boolean? = null): RootGameruleDoLimitedCraftingValueCommand {
        return RootGameruleDoLimitedCraftingValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleDoLimitedCraftingValueCommand {
        return value(value)
    }
}

class RootGameruleDoMobLootValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleDoMobLootCommand(
    parent: CommandNode
): CommandLiteral(parent, "doMobLoot") {
    fun value(value: Boolean? = null): RootGameruleDoMobLootValueCommand {
        return RootGameruleDoMobLootValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleDoMobLootValueCommand {
        return value(value)
    }
}

class RootGameruleDoMobSpawningValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleDoMobSpawningCommand(
    parent: CommandNode
): CommandLiteral(parent, "doMobSpawning") {
    fun value(value: Boolean? = null): RootGameruleDoMobSpawningValueCommand {
        return RootGameruleDoMobSpawningValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleDoMobSpawningValueCommand {
        return value(value)
    }
}

class RootGameruleDoPatrolSpawningValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleDoPatrolSpawningCommand(
    parent: CommandNode
): CommandLiteral(parent, "doPatrolSpawning") {
    fun value(value: Boolean? = null): RootGameruleDoPatrolSpawningValueCommand {
        return RootGameruleDoPatrolSpawningValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleDoPatrolSpawningValueCommand {
        return value(value)
    }
}

class RootGameruleDoTileDropsValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleDoTileDropsCommand(
    parent: CommandNode
): CommandLiteral(parent, "doTileDrops") {
    fun value(value: Boolean? = null): RootGameruleDoTileDropsValueCommand {
        return RootGameruleDoTileDropsValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleDoTileDropsValueCommand {
        return value(value)
    }
}

class RootGameruleDoTraderSpawningValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleDoTraderSpawningCommand(
    parent: CommandNode
): CommandLiteral(parent, "doTraderSpawning") {
    fun value(value: Boolean? = null): RootGameruleDoTraderSpawningValueCommand {
        return RootGameruleDoTraderSpawningValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleDoTraderSpawningValueCommand {
        return value(value)
    }
}

class RootGameruleDoWeatherCycleValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleDoWeatherCycleCommand(
    parent: CommandNode
): CommandLiteral(parent, "doWeatherCycle") {
    fun value(value: Boolean? = null): RootGameruleDoWeatherCycleValueCommand {
        return RootGameruleDoWeatherCycleValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleDoWeatherCycleValueCommand {
        return value(value)
    }
}

class RootGameruleDrowningDamageValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleDrowningDamageCommand(
    parent: CommandNode
): CommandLiteral(parent, "drowningDamage") {
    fun value(value: Boolean? = null): RootGameruleDrowningDamageValueCommand {
        return RootGameruleDrowningDamageValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleDrowningDamageValueCommand {
        return value(value)
    }
}

class RootGameruleFallDamageValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleFallDamageCommand(
    parent: CommandNode
): CommandLiteral(parent, "fallDamage") {
    fun value(value: Boolean? = null): RootGameruleFallDamageValueCommand {
        return RootGameruleFallDamageValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleFallDamageValueCommand {
        return value(value)
    }
}

class RootGameruleFireDamageValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleFireDamageCommand(
    parent: CommandNode
): CommandLiteral(parent, "fireDamage") {
    fun value(value: Boolean? = null): RootGameruleFireDamageValueCommand {
        return RootGameruleFireDamageValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleFireDamageValueCommand {
        return value(value)
    }
}

class RootGameruleForgiveDeadPlayersValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleForgiveDeadPlayersCommand(
    parent: CommandNode
): CommandLiteral(parent, "forgiveDeadPlayers") {
    fun value(value: Boolean? = null): RootGameruleForgiveDeadPlayersValueCommand {
        return RootGameruleForgiveDeadPlayersValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleForgiveDeadPlayersValueCommand {
        return value(value)
    }
}

class RootGameruleKeepInventoryValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleKeepInventoryCommand(
    parent: CommandNode
): CommandLiteral(parent, "keepInventory") {
    fun value(value: Boolean? = null): RootGameruleKeepInventoryValueCommand {
        return RootGameruleKeepInventoryValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleKeepInventoryValueCommand {
        return value(value)
    }
}

class RootGameruleLogAdminCommandsValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleLogAdminCommandsCommand(
    parent: CommandNode
): CommandLiteral(parent, "logAdminCommands") {
    fun value(value: Boolean? = null): RootGameruleLogAdminCommandsValueCommand {
        return RootGameruleLogAdminCommandsValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleLogAdminCommandsValueCommand {
        return value(value)
    }
}

class RootGameruleMaxCommandChainLengthValueCommand(
    parent: CommandNode,
    value: Int? = null
): CommandArgument(parent, value)

class RootGameruleMaxCommandChainLengthCommand(
    parent: CommandNode
): CommandLiteral(parent, "maxCommandChainLength") {
    fun value(value: Int? = null): RootGameruleMaxCommandChainLengthValueCommand {
        return RootGameruleMaxCommandChainLengthValueCommand(this, value)
    }

    operator fun invoke(value: Int? = null): RootGameruleMaxCommandChainLengthValueCommand {
        return value(value)
    }
}

class RootGameruleMaxEntityCrammingValueCommand(
    parent: CommandNode,
    value: Int? = null
): CommandArgument(parent, value)

class RootGameruleMaxEntityCrammingCommand(
    parent: CommandNode
): CommandLiteral(parent, "maxEntityCramming") {
    fun value(value: Int? = null): RootGameruleMaxEntityCrammingValueCommand {
        return RootGameruleMaxEntityCrammingValueCommand(this, value)
    }

    operator fun invoke(value: Int? = null): RootGameruleMaxEntityCrammingValueCommand {
        return value(value)
    }
}

class RootGameruleMobGriefingValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleMobGriefingCommand(
    parent: CommandNode
): CommandLiteral(parent, "mobGriefing") {
    fun value(value: Boolean? = null): RootGameruleMobGriefingValueCommand {
        return RootGameruleMobGriefingValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleMobGriefingValueCommand {
        return value(value)
    }
}

class RootGameruleNaturalRegenerationValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleNaturalRegenerationCommand(
    parent: CommandNode
): CommandLiteral(parent, "naturalRegeneration") {
    fun value(value: Boolean? = null): RootGameruleNaturalRegenerationValueCommand {
        return RootGameruleNaturalRegenerationValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleNaturalRegenerationValueCommand {
        return value(value)
    }
}

class RootGameruleRandomTickSpeedValueCommand(
    parent: CommandNode,
    value: Int? = null
): CommandArgument(parent, value)

class RootGameruleRandomTickSpeedCommand(
    parent: CommandNode
): CommandLiteral(parent, "randomTickSpeed") {
    fun value(value: Int? = null): RootGameruleRandomTickSpeedValueCommand {
        return RootGameruleRandomTickSpeedValueCommand(this, value)
    }

    operator fun invoke(value: Int? = null): RootGameruleRandomTickSpeedValueCommand {
        return value(value)
    }
}

class RootGameruleReducedDebugInfoValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleReducedDebugInfoCommand(
    parent: CommandNode
): CommandLiteral(parent, "reducedDebugInfo") {
    fun value(value: Boolean? = null): RootGameruleReducedDebugInfoValueCommand {
        return RootGameruleReducedDebugInfoValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleReducedDebugInfoValueCommand {
        return value(value)
    }
}

class RootGameruleSendCommandFeedbackValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleSendCommandFeedbackCommand(
    parent: CommandNode
): CommandLiteral(parent, "sendCommandFeedback") {
    fun value(value: Boolean? = null): RootGameruleSendCommandFeedbackValueCommand {
        return RootGameruleSendCommandFeedbackValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleSendCommandFeedbackValueCommand {
        return value(value)
    }
}

class RootGameruleShowDeathMessagesValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleShowDeathMessagesCommand(
    parent: CommandNode
): CommandLiteral(parent, "showDeathMessages") {
    fun value(value: Boolean? = null): RootGameruleShowDeathMessagesValueCommand {
        return RootGameruleShowDeathMessagesValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleShowDeathMessagesValueCommand {
        return value(value)
    }
}

class RootGameruleSpawnRadiusValueCommand(
    parent: CommandNode,
    value: Int? = null
): CommandArgument(parent, value)

class RootGameruleSpawnRadiusCommand(
    parent: CommandNode
): CommandLiteral(parent, "spawnRadius") {
    fun value(value: Int? = null): RootGameruleSpawnRadiusValueCommand {
        return RootGameruleSpawnRadiusValueCommand(this, value)
    }

    operator fun invoke(value: Int? = null): RootGameruleSpawnRadiusValueCommand {
        return value(value)
    }
}

class RootGameruleSpectatorsGenerateChunksValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleSpectatorsGenerateChunksCommand(
    parent: CommandNode
): CommandLiteral(parent, "spectatorsGenerateChunks") {
    fun value(value: Boolean? = null): RootGameruleSpectatorsGenerateChunksValueCommand {
        return RootGameruleSpectatorsGenerateChunksValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleSpectatorsGenerateChunksValueCommand {
        return value(value)
    }
}

class RootGameruleUniversalAngerValueCommand(
    parent: CommandNode,
    value: Boolean? = null
): CommandArgument(parent, value)

class RootGameruleUniversalAngerCommand(
    parent: CommandNode
): CommandLiteral(parent, "universalAnger") {
    fun value(value: Boolean? = null): RootGameruleUniversalAngerValueCommand {
        return RootGameruleUniversalAngerValueCommand(this, value)
    }

    operator fun invoke(value: Boolean? = null): RootGameruleUniversalAngerValueCommand {
        return value(value)
    }
}

class RootGameruleCommand(
    parent: CommandNode?,
    literal: String? = "gamerule"
): CommandLiteral(parent, literal) {
    val announceAdvancements = RootGameruleAnnounceAdvancementsCommand(this)
    val commandBlockOutput = RootGameruleCommandBlockOutputCommand(this)
    val disableElytraMovementCheck = RootGameruleDisableElytraMovementCheckCommand(this)
    val disableRaids = RootGameruleDisableRaidsCommand(this)
    val doDaylightCycle = RootGameruleDoDaylightCycleCommand(this)
    val doEntityDrops = RootGameruleDoEntityDropsCommand(this)
    val doFireTick = RootGameruleDoFireTickCommand(this)
    val doImmediateRespawn = RootGameruleDoImmediateRespawnCommand(this)
    val doInsomnia = RootGameruleDoInsomniaCommand(this)
    val doLimitedCrafting = RootGameruleDoLimitedCraftingCommand(this)
    val doMobLoot = RootGameruleDoMobLootCommand(this)
    val doMobSpawning = RootGameruleDoMobSpawningCommand(this)
    val doPatrolSpawning = RootGameruleDoPatrolSpawningCommand(this)
    val doTileDrops = RootGameruleDoTileDropsCommand(this)
    val doTraderSpawning = RootGameruleDoTraderSpawningCommand(this)
    val doWeatherCycle = RootGameruleDoWeatherCycleCommand(this)
    val drowningDamage = RootGameruleDrowningDamageCommand(this)
    val fallDamage = RootGameruleFallDamageCommand(this)
    val fireDamage = RootGameruleFireDamageCommand(this)
    val forgiveDeadPlayers = RootGameruleForgiveDeadPlayersCommand(this)
    val keepInventory = RootGameruleKeepInventoryCommand(this)
    val logAdminCommands = RootGameruleLogAdminCommandsCommand(this)
    val maxCommandChainLength = RootGameruleMaxCommandChainLengthCommand(this)
    val maxEntityCramming = RootGameruleMaxEntityCrammingCommand(this)
    val mobGriefing = RootGameruleMobGriefingCommand(this)
    val naturalRegeneration = RootGameruleNaturalRegenerationCommand(this)
    val randomTickSpeed = RootGameruleRandomTickSpeedCommand(this)
    val reducedDebugInfo = RootGameruleReducedDebugInfoCommand(this)
    val sendCommandFeedback = RootGameruleSendCommandFeedbackCommand(this)
    val showDeathMessages = RootGameruleShowDeathMessagesCommand(this)
    val spawnRadius = RootGameruleSpawnRadiusCommand(this)
    val spectatorsGenerateChunks = RootGameruleSpectatorsGenerateChunksCommand(this)
    val universalAnger = RootGameruleUniversalAngerCommand(this)
}
val gamerule = RootGameruleCommand(null)