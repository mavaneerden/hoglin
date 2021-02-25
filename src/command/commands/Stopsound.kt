package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootStopsoundTargetsAllSoundCommand(
    parent: CommandNode,
    sound: String? = null
): CommandArgument(parent, sound)

class RootStopsoundTargetsAllCommand(
    parent: CommandNode,
    literal: String? = "*"
): CommandLiteral(parent, literal) {
    fun sound(sound: String? = null): RootStopsoundTargetsAllSoundCommand {
        return RootStopsoundTargetsAllSoundCommand(this, sound)
    }

    operator fun invoke(sound: String? = null): RootStopsoundTargetsAllSoundCommand {
        return sound(sound)
    }
}

class RootStopsoundTargetsAmbientSoundCommand(
    parent: CommandNode,
    sound: String? = null
): CommandArgument(parent, sound)

class RootStopsoundTargetsAmbientCommand(
    parent: CommandNode,
    literal: String? = "ambient"
): CommandLiteral(parent, literal) {
    fun sound(sound: String? = null): RootStopsoundTargetsAmbientSoundCommand {
        return RootStopsoundTargetsAmbientSoundCommand(this, sound)
    }

    operator fun invoke(sound: String? = null): RootStopsoundTargetsAmbientSoundCommand {
        return sound(sound)
    }
}

class RootStopsoundTargetsBlockSoundCommand(
    parent: CommandNode,
    sound: String? = null
): CommandArgument(parent, sound)

class RootStopsoundTargetsBlockCommand(
    parent: CommandNode,
    literal: String? = "block"
): CommandLiteral(parent, literal) {
    fun sound(sound: String? = null): RootStopsoundTargetsBlockSoundCommand {
        return RootStopsoundTargetsBlockSoundCommand(this, sound)
    }

    operator fun invoke(sound: String? = null): RootStopsoundTargetsBlockSoundCommand {
        return sound(sound)
    }
}

class RootStopsoundTargetsHostileSoundCommand(
    parent: CommandNode,
    sound: String? = null
): CommandArgument(parent, sound)

class RootStopsoundTargetsHostileCommand(
    parent: CommandNode,
    literal: String? = "hostile"
): CommandLiteral(parent, literal) {
    fun sound(sound: String? = null): RootStopsoundTargetsHostileSoundCommand {
        return RootStopsoundTargetsHostileSoundCommand(this, sound)
    }

    operator fun invoke(sound: String? = null): RootStopsoundTargetsHostileSoundCommand {
        return sound(sound)
    }
}

class RootStopsoundTargetsMasterSoundCommand(
    parent: CommandNode,
    sound: String? = null
): CommandArgument(parent, sound)

class RootStopsoundTargetsMasterCommand(
    parent: CommandNode,
    literal: String? = "master"
): CommandLiteral(parent, literal) {
    fun sound(sound: String? = null): RootStopsoundTargetsMasterSoundCommand {
        return RootStopsoundTargetsMasterSoundCommand(this, sound)
    }

    operator fun invoke(sound: String? = null): RootStopsoundTargetsMasterSoundCommand {
        return sound(sound)
    }
}

class RootStopsoundTargetsMusicSoundCommand(
    parent: CommandNode,
    sound: String? = null
): CommandArgument(parent, sound)

class RootStopsoundTargetsMusicCommand(
    parent: CommandNode,
    literal: String? = "music"
): CommandLiteral(parent, literal) {
    fun sound(sound: String? = null): RootStopsoundTargetsMusicSoundCommand {
        return RootStopsoundTargetsMusicSoundCommand(this, sound)
    }

    operator fun invoke(sound: String? = null): RootStopsoundTargetsMusicSoundCommand {
        return sound(sound)
    }
}

class RootStopsoundTargetsNeutralSoundCommand(
    parent: CommandNode,
    sound: String? = null
): CommandArgument(parent, sound)

class RootStopsoundTargetsNeutralCommand(
    parent: CommandNode,
    literal: String? = "neutral"
): CommandLiteral(parent, literal) {
    fun sound(sound: String? = null): RootStopsoundTargetsNeutralSoundCommand {
        return RootStopsoundTargetsNeutralSoundCommand(this, sound)
    }

    operator fun invoke(sound: String? = null): RootStopsoundTargetsNeutralSoundCommand {
        return sound(sound)
    }
}

class RootStopsoundTargetsPlayerSoundCommand(
    parent: CommandNode,
    sound: String? = null
): CommandArgument(parent, sound)

class RootStopsoundTargetsPlayerCommand(
    parent: CommandNode,
    literal: String? = "player"
): CommandLiteral(parent, literal) {
    fun sound(sound: String? = null): RootStopsoundTargetsPlayerSoundCommand {
        return RootStopsoundTargetsPlayerSoundCommand(this, sound)
    }

    operator fun invoke(sound: String? = null): RootStopsoundTargetsPlayerSoundCommand {
        return sound(sound)
    }
}

class RootStopsoundTargetsRecordSoundCommand(
    parent: CommandNode,
    sound: String? = null
): CommandArgument(parent, sound)

class RootStopsoundTargetsRecordCommand(
    parent: CommandNode,
    literal: String? = "record"
): CommandLiteral(parent, literal) {
    fun sound(sound: String? = null): RootStopsoundTargetsRecordSoundCommand {
        return RootStopsoundTargetsRecordSoundCommand(this, sound)
    }

    operator fun invoke(sound: String? = null): RootStopsoundTargetsRecordSoundCommand {
        return sound(sound)
    }
}

class RootStopsoundTargetsVoiceSoundCommand(
    parent: CommandNode,
    sound: String? = null
): CommandArgument(parent, sound)

class RootStopsoundTargetsVoiceCommand(
    parent: CommandNode,
    literal: String? = "voice"
): CommandLiteral(parent, literal) {
    fun sound(sound: String? = null): RootStopsoundTargetsVoiceSoundCommand {
        return RootStopsoundTargetsVoiceSoundCommand(this, sound)
    }

    operator fun invoke(sound: String? = null): RootStopsoundTargetsVoiceSoundCommand {
        return sound(sound)
    }
}

class RootStopsoundTargetsWeatherSoundCommand(
    parent: CommandNode,
    sound: String? = null
): CommandArgument(parent, sound)

class RootStopsoundTargetsWeatherCommand(
    parent: CommandNode,
    literal: String? = "weather"
): CommandLiteral(parent, literal) {
    fun sound(sound: String? = null): RootStopsoundTargetsWeatherSoundCommand {
        return RootStopsoundTargetsWeatherSoundCommand(this, sound)
    }

    operator fun invoke(sound: String? = null): RootStopsoundTargetsWeatherSoundCommand {
        return sound(sound)
    }
}

class RootStopsoundTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    val all = RootStopsoundTargetsAllCommand(this)
    val ambient = RootStopsoundTargetsAmbientCommand(this)
    val block = RootStopsoundTargetsBlockCommand(this)
    val hostile = RootStopsoundTargetsHostileCommand(this)
    val master = RootStopsoundTargetsMasterCommand(this)
    val music = RootStopsoundTargetsMusicCommand(this)
    val neutral = RootStopsoundTargetsNeutralCommand(this)
    val player = RootStopsoundTargetsPlayerCommand(this)
    val record = RootStopsoundTargetsRecordCommand(this)
    val voice = RootStopsoundTargetsVoiceCommand(this)
    val weather = RootStopsoundTargetsWeatherCommand(this)
}

class RootStopsoundCommand(
    parent: CommandNode?,
    literal: String? = "stopsound"
): CommandLiteral(parent, literal) {
    fun targets(targets: Selector): RootStopsoundTargetsCommand {
        return RootStopsoundTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector): RootStopsoundTargetsCommand {
        return targets(targets)
    }
}
val stopsound = RootStopsoundCommand(null)