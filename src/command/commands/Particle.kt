package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootParticleNamePosDeltaSpeedCountForceViewersCommand(
    parent: CommandNode,
    viewers: Selector? = null
): CommandArgument(parent, viewers)

class RootParticleNamePosDeltaSpeedCountForceCommand(
    parent: CommandNode,
    literal: String? = "force"
): CommandLiteral(parent, literal) {
    fun viewers(viewers: Selector? = null): RootParticleNamePosDeltaSpeedCountForceViewersCommand {
        return RootParticleNamePosDeltaSpeedCountForceViewersCommand(this, viewers)
    }

    operator fun invoke(viewers: Selector? = null): RootParticleNamePosDeltaSpeedCountForceViewersCommand {
        return viewers(viewers)
    }
}

class RootParticleNamePosDeltaSpeedCountNormalViewersCommand(
    parent: CommandNode,
    viewers: Selector? = null
): CommandArgument(parent, viewers)

class RootParticleNamePosDeltaSpeedCountNormalCommand(
    parent: CommandNode,
    literal: String? = "normal"
): CommandLiteral(parent, literal) {
    fun viewers(viewers: Selector? = null): RootParticleNamePosDeltaSpeedCountNormalViewersCommand {
        return RootParticleNamePosDeltaSpeedCountNormalViewersCommand(this, viewers)
    }

    operator fun invoke(viewers: Selector? = null): RootParticleNamePosDeltaSpeedCountNormalViewersCommand {
        return viewers(viewers)
    }
}

class RootParticleNamePosDeltaSpeedCountCommand(
    parent: CommandNode,
    count: Int? = null
): CommandArgument(parent, count) {
    val force = RootParticleNamePosDeltaSpeedCountForceCommand(this)
    val normal = RootParticleNamePosDeltaSpeedCountNormalCommand(this)
}

class RootParticleNamePosDeltaSpeedCommand(
    parent: CommandNode,
    speed: Float? = null
): CommandArgument(parent, speed) {
    fun count(count: Int? = null): RootParticleNamePosDeltaSpeedCountCommand {
        return RootParticleNamePosDeltaSpeedCountCommand(this, count)
    }
}

class RootParticleNamePosDeltaCommand(
    parent: CommandNode,
    delta: Coordinates? = null
): CommandArgument(parent, delta) {
    fun speed(speed: Float? = null): RootParticleNamePosDeltaSpeedCommand {
        return RootParticleNamePosDeltaSpeedCommand(this, speed)
    }
}

class RootParticleNamePosCommand(
    parent: CommandNode,
    pos: Coordinates? = null
): CommandArgument(parent, pos) {
    fun delta(delta: Coordinates? = null): RootParticleNamePosDeltaCommand {
        return RootParticleNamePosDeltaCommand(this, delta)
    }
}

class RootParticleNameCommand(
    parent: CommandNode,
    name: String
): CommandArgument(parent, name) {
    fun pos(pos: Coordinates? = null): RootParticleNamePosCommand {
        return RootParticleNamePosCommand(this, pos)
    }
}

class RootParticleCommand(
    parent: CommandNode?,
    literal: String? = "particle"
): CommandLiteral(parent, literal) {
    fun name(name: String): RootParticleNameCommand {
        return RootParticleNameCommand(this, name)
    }

    operator fun invoke(name: String, pos: Coordinates? = null, delta: Coordinates? = null, speed: Float? = null, count: Int? = null): RootParticleNamePosDeltaSpeedCountCommand {
        return name(name).pos(pos).delta(delta).speed(speed).count(count)
    }
}
val particle = RootParticleCommand(null)