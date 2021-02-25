package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootPlaysoundSoundAmbientTargetsPosVolumePitchMinVolumeCommand(
    parent: CommandNode,
    minVolume: Float? = null
): CommandArgument(parent, minVolume)

class RootPlaysoundSoundAmbientTargetsPosVolumePitchCommand(
    parent: CommandNode,
    pitch: Float? = null
): CommandArgument(parent, pitch) {
    fun minVolume(minVolume: Float? = null): RootPlaysoundSoundAmbientTargetsPosVolumePitchMinVolumeCommand {
        return RootPlaysoundSoundAmbientTargetsPosVolumePitchMinVolumeCommand(this, minVolume)
    }
}

class RootPlaysoundSoundAmbientTargetsPosVolumeCommand(
    parent: CommandNode,
    volume: Float? = null
): CommandArgument(parent, volume) {
    fun pitch(pitch: Float? = null): RootPlaysoundSoundAmbientTargetsPosVolumePitchCommand {
        return RootPlaysoundSoundAmbientTargetsPosVolumePitchCommand(this, pitch)
    }
}

class RootPlaysoundSoundAmbientTargetsPosCommand(
    parent: CommandNode,
    pos: Coordinates? = null
): CommandArgument(parent, pos) {
    fun volume(volume: Float? = null): RootPlaysoundSoundAmbientTargetsPosVolumeCommand {
        return RootPlaysoundSoundAmbientTargetsPosVolumeCommand(this, volume)
    }
}

class RootPlaysoundSoundAmbientTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun pos(pos: Coordinates? = null): RootPlaysoundSoundAmbientTargetsPosCommand {
        return RootPlaysoundSoundAmbientTargetsPosCommand(this, pos)
    }
}

class RootPlaysoundSoundAmbientCommand(
    parent: CommandNode
): CommandLiteral(parent, "ambient") {
    fun targets(targets: Selector): RootPlaysoundSoundAmbientTargetsCommand {
        return RootPlaysoundSoundAmbientTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, pos: Coordinates? = null, volume: Float? = null, pitch: Float? = null, minVolume: Float? = null): RootPlaysoundSoundAmbientTargetsPosVolumePitchMinVolumeCommand {
        return targets(targets).pos(pos).volume(volume).pitch(pitch).minVolume(minVolume)
    }
}

class RootPlaysoundSoundBlockTargetsPosVolumePitchMinVolumeCommand(
    parent: CommandNode,
    minVolume: Float? = null
): CommandArgument(parent, minVolume)

class RootPlaysoundSoundBlockTargetsPosVolumePitchCommand(
    parent: CommandNode,
    pitch: Float? = null
): CommandArgument(parent, pitch) {
    fun minVolume(minVolume: Float? = null): RootPlaysoundSoundBlockTargetsPosVolumePitchMinVolumeCommand {
        return RootPlaysoundSoundBlockTargetsPosVolumePitchMinVolumeCommand(this, minVolume)
    }
}

class RootPlaysoundSoundBlockTargetsPosVolumeCommand(
    parent: CommandNode,
    volume: Float? = null
): CommandArgument(parent, volume) {
    fun pitch(pitch: Float? = null): RootPlaysoundSoundBlockTargetsPosVolumePitchCommand {
        return RootPlaysoundSoundBlockTargetsPosVolumePitchCommand(this, pitch)
    }
}

class RootPlaysoundSoundBlockTargetsPosCommand(
    parent: CommandNode,
    pos: Coordinates? = null
): CommandArgument(parent, pos) {
    fun volume(volume: Float? = null): RootPlaysoundSoundBlockTargetsPosVolumeCommand {
        return RootPlaysoundSoundBlockTargetsPosVolumeCommand(this, volume)
    }
}

class RootPlaysoundSoundBlockTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun pos(pos: Coordinates? = null): RootPlaysoundSoundBlockTargetsPosCommand {
        return RootPlaysoundSoundBlockTargetsPosCommand(this, pos)
    }
}

class RootPlaysoundSoundBlockCommand(
    parent: CommandNode
): CommandLiteral(parent, "block") {
    fun targets(targets: Selector): RootPlaysoundSoundBlockTargetsCommand {
        return RootPlaysoundSoundBlockTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, pos: Coordinates? = null, volume: Float? = null, pitch: Float? = null, minVolume: Float? = null): RootPlaysoundSoundBlockTargetsPosVolumePitchMinVolumeCommand {
        return targets(targets).pos(pos).volume(volume).pitch(pitch).minVolume(minVolume)
    }
}

class RootPlaysoundSoundHostileTargetsPosVolumePitchMinVolumeCommand(
    parent: CommandNode,
    minVolume: Float? = null
): CommandArgument(parent, minVolume)

class RootPlaysoundSoundHostileTargetsPosVolumePitchCommand(
    parent: CommandNode,
    pitch: Float? = null
): CommandArgument(parent, pitch) {
    fun minVolume(minVolume: Float? = null): RootPlaysoundSoundHostileTargetsPosVolumePitchMinVolumeCommand {
        return RootPlaysoundSoundHostileTargetsPosVolumePitchMinVolumeCommand(this, minVolume)
    }
}

class RootPlaysoundSoundHostileTargetsPosVolumeCommand(
    parent: CommandNode,
    volume: Float? = null
): CommandArgument(parent, volume) {
    fun pitch(pitch: Float? = null): RootPlaysoundSoundHostileTargetsPosVolumePitchCommand {
        return RootPlaysoundSoundHostileTargetsPosVolumePitchCommand(this, pitch)
    }
}

class RootPlaysoundSoundHostileTargetsPosCommand(
    parent: CommandNode,
    pos: Coordinates? = null
): CommandArgument(parent, pos) {
    fun volume(volume: Float? = null): RootPlaysoundSoundHostileTargetsPosVolumeCommand {
        return RootPlaysoundSoundHostileTargetsPosVolumeCommand(this, volume)
    }
}

class RootPlaysoundSoundHostileTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun pos(pos: Coordinates? = null): RootPlaysoundSoundHostileTargetsPosCommand {
        return RootPlaysoundSoundHostileTargetsPosCommand(this, pos)
    }
}

class RootPlaysoundSoundHostileCommand(
    parent: CommandNode
): CommandLiteral(parent, "hostile") {
    fun targets(targets: Selector): RootPlaysoundSoundHostileTargetsCommand {
        return RootPlaysoundSoundHostileTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, pos: Coordinates? = null, volume: Float? = null, pitch: Float? = null, minVolume: Float? = null): RootPlaysoundSoundHostileTargetsPosVolumePitchMinVolumeCommand {
        return targets(targets).pos(pos).volume(volume).pitch(pitch).minVolume(minVolume)
    }
}

class RootPlaysoundSoundMasterTargetsPosVolumePitchMinVolumeCommand(
    parent: CommandNode,
    minVolume: Float? = null
): CommandArgument(parent, minVolume)

class RootPlaysoundSoundMasterTargetsPosVolumePitchCommand(
    parent: CommandNode,
    pitch: Float? = null
): CommandArgument(parent, pitch) {
    fun minVolume(minVolume: Float? = null): RootPlaysoundSoundMasterTargetsPosVolumePitchMinVolumeCommand {
        return RootPlaysoundSoundMasterTargetsPosVolumePitchMinVolumeCommand(this, minVolume)
    }
}

class RootPlaysoundSoundMasterTargetsPosVolumeCommand(
    parent: CommandNode,
    volume: Float? = null
): CommandArgument(parent, volume) {
    fun pitch(pitch: Float? = null): RootPlaysoundSoundMasterTargetsPosVolumePitchCommand {
        return RootPlaysoundSoundMasterTargetsPosVolumePitchCommand(this, pitch)
    }
}

class RootPlaysoundSoundMasterTargetsPosCommand(
    parent: CommandNode,
    pos: Coordinates? = null
): CommandArgument(parent, pos) {
    fun volume(volume: Float? = null): RootPlaysoundSoundMasterTargetsPosVolumeCommand {
        return RootPlaysoundSoundMasterTargetsPosVolumeCommand(this, volume)
    }
}

class RootPlaysoundSoundMasterTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun pos(pos: Coordinates? = null): RootPlaysoundSoundMasterTargetsPosCommand {
        return RootPlaysoundSoundMasterTargetsPosCommand(this, pos)
    }
}

class RootPlaysoundSoundMasterCommand(
    parent: CommandNode
): CommandLiteral(parent, "master") {
    fun targets(targets: Selector): RootPlaysoundSoundMasterTargetsCommand {
        return RootPlaysoundSoundMasterTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, pos: Coordinates? = null, volume: Float? = null, pitch: Float? = null, minVolume: Float? = null): RootPlaysoundSoundMasterTargetsPosVolumePitchMinVolumeCommand {
        return targets(targets).pos(pos).volume(volume).pitch(pitch).minVolume(minVolume)
    }
}

class RootPlaysoundSoundMusicTargetsPosVolumePitchMinVolumeCommand(
    parent: CommandNode,
    minVolume: Float? = null
): CommandArgument(parent, minVolume)

class RootPlaysoundSoundMusicTargetsPosVolumePitchCommand(
    parent: CommandNode,
    pitch: Float? = null
): CommandArgument(parent, pitch) {
    fun minVolume(minVolume: Float? = null): RootPlaysoundSoundMusicTargetsPosVolumePitchMinVolumeCommand {
        return RootPlaysoundSoundMusicTargetsPosVolumePitchMinVolumeCommand(this, minVolume)
    }
}

class RootPlaysoundSoundMusicTargetsPosVolumeCommand(
    parent: CommandNode,
    volume: Float? = null
): CommandArgument(parent, volume) {
    fun pitch(pitch: Float? = null): RootPlaysoundSoundMusicTargetsPosVolumePitchCommand {
        return RootPlaysoundSoundMusicTargetsPosVolumePitchCommand(this, pitch)
    }
}

class RootPlaysoundSoundMusicTargetsPosCommand(
    parent: CommandNode,
    pos: Coordinates? = null
): CommandArgument(parent, pos) {
    fun volume(volume: Float? = null): RootPlaysoundSoundMusicTargetsPosVolumeCommand {
        return RootPlaysoundSoundMusicTargetsPosVolumeCommand(this, volume)
    }
}

class RootPlaysoundSoundMusicTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun pos(pos: Coordinates? = null): RootPlaysoundSoundMusicTargetsPosCommand {
        return RootPlaysoundSoundMusicTargetsPosCommand(this, pos)
    }
}

class RootPlaysoundSoundMusicCommand(
    parent: CommandNode
): CommandLiteral(parent, "music") {
    fun targets(targets: Selector): RootPlaysoundSoundMusicTargetsCommand {
        return RootPlaysoundSoundMusicTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, pos: Coordinates? = null, volume: Float? = null, pitch: Float? = null, minVolume: Float? = null): RootPlaysoundSoundMusicTargetsPosVolumePitchMinVolumeCommand {
        return targets(targets).pos(pos).volume(volume).pitch(pitch).minVolume(minVolume)
    }
}

class RootPlaysoundSoundNeutralTargetsPosVolumePitchMinVolumeCommand(
    parent: CommandNode,
    minVolume: Float? = null
): CommandArgument(parent, minVolume)

class RootPlaysoundSoundNeutralTargetsPosVolumePitchCommand(
    parent: CommandNode,
    pitch: Float? = null
): CommandArgument(parent, pitch) {
    fun minVolume(minVolume: Float? = null): RootPlaysoundSoundNeutralTargetsPosVolumePitchMinVolumeCommand {
        return RootPlaysoundSoundNeutralTargetsPosVolumePitchMinVolumeCommand(this, minVolume)
    }
}

class RootPlaysoundSoundNeutralTargetsPosVolumeCommand(
    parent: CommandNode,
    volume: Float? = null
): CommandArgument(parent, volume) {
    fun pitch(pitch: Float? = null): RootPlaysoundSoundNeutralTargetsPosVolumePitchCommand {
        return RootPlaysoundSoundNeutralTargetsPosVolumePitchCommand(this, pitch)
    }
}

class RootPlaysoundSoundNeutralTargetsPosCommand(
    parent: CommandNode,
    pos: Coordinates? = null
): CommandArgument(parent, pos) {
    fun volume(volume: Float? = null): RootPlaysoundSoundNeutralTargetsPosVolumeCommand {
        return RootPlaysoundSoundNeutralTargetsPosVolumeCommand(this, volume)
    }
}

class RootPlaysoundSoundNeutralTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun pos(pos: Coordinates? = null): RootPlaysoundSoundNeutralTargetsPosCommand {
        return RootPlaysoundSoundNeutralTargetsPosCommand(this, pos)
    }
}

class RootPlaysoundSoundNeutralCommand(
    parent: CommandNode
): CommandLiteral(parent, "neutral") {
    fun targets(targets: Selector): RootPlaysoundSoundNeutralTargetsCommand {
        return RootPlaysoundSoundNeutralTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, pos: Coordinates? = null, volume: Float? = null, pitch: Float? = null, minVolume: Float? = null): RootPlaysoundSoundNeutralTargetsPosVolumePitchMinVolumeCommand {
        return targets(targets).pos(pos).volume(volume).pitch(pitch).minVolume(minVolume)
    }
}

class RootPlaysoundSoundPlayerTargetsPosVolumePitchMinVolumeCommand(
    parent: CommandNode,
    minVolume: Float? = null
): CommandArgument(parent, minVolume)

class RootPlaysoundSoundPlayerTargetsPosVolumePitchCommand(
    parent: CommandNode,
    pitch: Float? = null
): CommandArgument(parent, pitch) {
    fun minVolume(minVolume: Float? = null): RootPlaysoundSoundPlayerTargetsPosVolumePitchMinVolumeCommand {
        return RootPlaysoundSoundPlayerTargetsPosVolumePitchMinVolumeCommand(this, minVolume)
    }
}

class RootPlaysoundSoundPlayerTargetsPosVolumeCommand(
    parent: CommandNode,
    volume: Float? = null
): CommandArgument(parent, volume) {
    fun pitch(pitch: Float? = null): RootPlaysoundSoundPlayerTargetsPosVolumePitchCommand {
        return RootPlaysoundSoundPlayerTargetsPosVolumePitchCommand(this, pitch)
    }
}

class RootPlaysoundSoundPlayerTargetsPosCommand(
    parent: CommandNode,
    pos: Coordinates? = null
): CommandArgument(parent, pos) {
    fun volume(volume: Float? = null): RootPlaysoundSoundPlayerTargetsPosVolumeCommand {
        return RootPlaysoundSoundPlayerTargetsPosVolumeCommand(this, volume)
    }
}

class RootPlaysoundSoundPlayerTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun pos(pos: Coordinates? = null): RootPlaysoundSoundPlayerTargetsPosCommand {
        return RootPlaysoundSoundPlayerTargetsPosCommand(this, pos)
    }
}

class RootPlaysoundSoundPlayerCommand(
    parent: CommandNode
): CommandLiteral(parent, "player") {
    fun targets(targets: Selector): RootPlaysoundSoundPlayerTargetsCommand {
        return RootPlaysoundSoundPlayerTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, pos: Coordinates? = null, volume: Float? = null, pitch: Float? = null, minVolume: Float? = null): RootPlaysoundSoundPlayerTargetsPosVolumePitchMinVolumeCommand {
        return targets(targets).pos(pos).volume(volume).pitch(pitch).minVolume(minVolume)
    }
}

class RootPlaysoundSoundRecordTargetsPosVolumePitchMinVolumeCommand(
    parent: CommandNode,
    minVolume: Float? = null
): CommandArgument(parent, minVolume)

class RootPlaysoundSoundRecordTargetsPosVolumePitchCommand(
    parent: CommandNode,
    pitch: Float? = null
): CommandArgument(parent, pitch) {
    fun minVolume(minVolume: Float? = null): RootPlaysoundSoundRecordTargetsPosVolumePitchMinVolumeCommand {
        return RootPlaysoundSoundRecordTargetsPosVolumePitchMinVolumeCommand(this, minVolume)
    }
}

class RootPlaysoundSoundRecordTargetsPosVolumeCommand(
    parent: CommandNode,
    volume: Float? = null
): CommandArgument(parent, volume) {
    fun pitch(pitch: Float? = null): RootPlaysoundSoundRecordTargetsPosVolumePitchCommand {
        return RootPlaysoundSoundRecordTargetsPosVolumePitchCommand(this, pitch)
    }
}

class RootPlaysoundSoundRecordTargetsPosCommand(
    parent: CommandNode,
    pos: Coordinates? = null
): CommandArgument(parent, pos) {
    fun volume(volume: Float? = null): RootPlaysoundSoundRecordTargetsPosVolumeCommand {
        return RootPlaysoundSoundRecordTargetsPosVolumeCommand(this, volume)
    }
}

class RootPlaysoundSoundRecordTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun pos(pos: Coordinates? = null): RootPlaysoundSoundRecordTargetsPosCommand {
        return RootPlaysoundSoundRecordTargetsPosCommand(this, pos)
    }
}

class RootPlaysoundSoundRecordCommand(
    parent: CommandNode
): CommandLiteral(parent, "record") {
    fun targets(targets: Selector): RootPlaysoundSoundRecordTargetsCommand {
        return RootPlaysoundSoundRecordTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, pos: Coordinates? = null, volume: Float? = null, pitch: Float? = null, minVolume: Float? = null): RootPlaysoundSoundRecordTargetsPosVolumePitchMinVolumeCommand {
        return targets(targets).pos(pos).volume(volume).pitch(pitch).minVolume(minVolume)
    }
}

class RootPlaysoundSoundVoiceTargetsPosVolumePitchMinVolumeCommand(
    parent: CommandNode,
    minVolume: Float? = null
): CommandArgument(parent, minVolume)

class RootPlaysoundSoundVoiceTargetsPosVolumePitchCommand(
    parent: CommandNode,
    pitch: Float? = null
): CommandArgument(parent, pitch) {
    fun minVolume(minVolume: Float? = null): RootPlaysoundSoundVoiceTargetsPosVolumePitchMinVolumeCommand {
        return RootPlaysoundSoundVoiceTargetsPosVolumePitchMinVolumeCommand(this, minVolume)
    }
}

class RootPlaysoundSoundVoiceTargetsPosVolumeCommand(
    parent: CommandNode,
    volume: Float? = null
): CommandArgument(parent, volume) {
    fun pitch(pitch: Float? = null): RootPlaysoundSoundVoiceTargetsPosVolumePitchCommand {
        return RootPlaysoundSoundVoiceTargetsPosVolumePitchCommand(this, pitch)
    }
}

class RootPlaysoundSoundVoiceTargetsPosCommand(
    parent: CommandNode,
    pos: Coordinates? = null
): CommandArgument(parent, pos) {
    fun volume(volume: Float? = null): RootPlaysoundSoundVoiceTargetsPosVolumeCommand {
        return RootPlaysoundSoundVoiceTargetsPosVolumeCommand(this, volume)
    }
}

class RootPlaysoundSoundVoiceTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun pos(pos: Coordinates? = null): RootPlaysoundSoundVoiceTargetsPosCommand {
        return RootPlaysoundSoundVoiceTargetsPosCommand(this, pos)
    }
}

class RootPlaysoundSoundVoiceCommand(
    parent: CommandNode
): CommandLiteral(parent, "voice") {
    fun targets(targets: Selector): RootPlaysoundSoundVoiceTargetsCommand {
        return RootPlaysoundSoundVoiceTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, pos: Coordinates? = null, volume: Float? = null, pitch: Float? = null, minVolume: Float? = null): RootPlaysoundSoundVoiceTargetsPosVolumePitchMinVolumeCommand {
        return targets(targets).pos(pos).volume(volume).pitch(pitch).minVolume(minVolume)
    }
}

class RootPlaysoundSoundWeatherTargetsPosVolumePitchMinVolumeCommand(
    parent: CommandNode,
    minVolume: Float? = null
): CommandArgument(parent, minVolume)

class RootPlaysoundSoundWeatherTargetsPosVolumePitchCommand(
    parent: CommandNode,
    pitch: Float? = null
): CommandArgument(parent, pitch) {
    fun minVolume(minVolume: Float? = null): RootPlaysoundSoundWeatherTargetsPosVolumePitchMinVolumeCommand {
        return RootPlaysoundSoundWeatherTargetsPosVolumePitchMinVolumeCommand(this, minVolume)
    }
}

class RootPlaysoundSoundWeatherTargetsPosVolumeCommand(
    parent: CommandNode,
    volume: Float? = null
): CommandArgument(parent, volume) {
    fun pitch(pitch: Float? = null): RootPlaysoundSoundWeatherTargetsPosVolumePitchCommand {
        return RootPlaysoundSoundWeatherTargetsPosVolumePitchCommand(this, pitch)
    }
}

class RootPlaysoundSoundWeatherTargetsPosCommand(
    parent: CommandNode,
    pos: Coordinates? = null
): CommandArgument(parent, pos) {
    fun volume(volume: Float? = null): RootPlaysoundSoundWeatherTargetsPosVolumeCommand {
        return RootPlaysoundSoundWeatherTargetsPosVolumeCommand(this, volume)
    }
}

class RootPlaysoundSoundWeatherTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun pos(pos: Coordinates? = null): RootPlaysoundSoundWeatherTargetsPosCommand {
        return RootPlaysoundSoundWeatherTargetsPosCommand(this, pos)
    }
}

class RootPlaysoundSoundWeatherCommand(
    parent: CommandNode
): CommandLiteral(parent, "weather") {
    fun targets(targets: Selector): RootPlaysoundSoundWeatherTargetsCommand {
        return RootPlaysoundSoundWeatherTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, pos: Coordinates? = null, volume: Float? = null, pitch: Float? = null, minVolume: Float? = null): RootPlaysoundSoundWeatherTargetsPosVolumePitchMinVolumeCommand {
        return targets(targets).pos(pos).volume(volume).pitch(pitch).minVolume(minVolume)
    }
}

class RootPlaysoundSoundCommand(
    parent: CommandNode,
    sound: String
): CommandArgument(parent, sound) {
    val ambient = RootPlaysoundSoundAmbientCommand(this)
    val block = RootPlaysoundSoundBlockCommand(this)
    val hostile = RootPlaysoundSoundHostileCommand(this)
    val master = RootPlaysoundSoundMasterCommand(this)
    val music = RootPlaysoundSoundMusicCommand(this)
    val neutral = RootPlaysoundSoundNeutralCommand(this)
    val player = RootPlaysoundSoundPlayerCommand(this)
    val record = RootPlaysoundSoundRecordCommand(this)
    val voice = RootPlaysoundSoundVoiceCommand(this)
    val weather = RootPlaysoundSoundWeatherCommand(this)
}

class RootPlaysoundCommand(
    parent: CommandNode?,
    literal: String? = "playsound"
): CommandLiteral(parent, literal) {
    fun sound(sound: String): RootPlaysoundSoundCommand {
        return RootPlaysoundSoundCommand(this, sound)
    }

    operator fun invoke(sound: String): RootPlaysoundSoundCommand {
        return sound(sound)
    }
}
val playsound = RootPlaysoundCommand(null)