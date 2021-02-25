package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootGamemodeAdventureTargetCommand(
    parent: CommandNode,
    target: Selector? = null
): CommandArgument(parent, target)

class RootGamemodeAdventureCommand(
    parent: CommandNode
): CommandLiteral(parent, "adventure") {
    fun target(target: Selector? = null): RootGamemodeAdventureTargetCommand {
        return RootGamemodeAdventureTargetCommand(this, target)
    }

    operator fun invoke(target: Selector? = null): RootGamemodeAdventureTargetCommand {
        return target(target)
    }
}

class RootGamemodeCreativeTargetCommand(
    parent: CommandNode,
    target: Selector? = null
): CommandArgument(parent, target)

class RootGamemodeCreativeCommand(
    parent: CommandNode
): CommandLiteral(parent, "creative") {
    fun target(target: Selector? = null): RootGamemodeCreativeTargetCommand {
        return RootGamemodeCreativeTargetCommand(this, target)
    }

    operator fun invoke(target: Selector? = null): RootGamemodeCreativeTargetCommand {
        return target(target)
    }
}

class RootGamemodeSpectatorTargetCommand(
    parent: CommandNode,
    target: Selector? = null
): CommandArgument(parent, target)

class RootGamemodeSpectatorCommand(
    parent: CommandNode
): CommandLiteral(parent, "spectator") {
    fun target(target: Selector? = null): RootGamemodeSpectatorTargetCommand {
        return RootGamemodeSpectatorTargetCommand(this, target)
    }

    operator fun invoke(target: Selector? = null): RootGamemodeSpectatorTargetCommand {
        return target(target)
    }
}

class RootGamemodeSurvivalTargetCommand(
    parent: CommandNode,
    target: Selector? = null
): CommandArgument(parent, target)

class RootGamemodeSurvivalCommand(
    parent: CommandNode
): CommandLiteral(parent, "survival") {
    fun target(target: Selector? = null): RootGamemodeSurvivalTargetCommand {
        return RootGamemodeSurvivalTargetCommand(this, target)
    }

    operator fun invoke(target: Selector? = null): RootGamemodeSurvivalTargetCommand {
        return target(target)
    }
}

class RootGamemodeCommand(
    parent: CommandNode?,
    literal: String? = "gamemode"
): CommandLiteral(parent, literal) {
    val adventure = RootGamemodeAdventureCommand(this)
    val creative = RootGamemodeCreativeCommand(this)
    val spectator = RootGamemodeSpectatorCommand(this)
    val survival = RootGamemodeSurvivalCommand(this)
}
val gamemode = RootGamemodeCommand(null)