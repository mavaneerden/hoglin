package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootEffectClearTargetsEffectCommand(
    parent: CommandNode,
    effect: String? = null
): CommandArgument(parent, effect)

class RootEffectClearTargetsCommand(
    parent: CommandNode,
    targets: Selector? = null
): CommandArgument(parent, targets) {
    fun effect(effect: String? = null): RootEffectClearTargetsEffectCommand {
        return RootEffectClearTargetsEffectCommand(this, effect)
    }
}

class RootEffectClearCommand(
    parent: CommandNode
): CommandLiteral(parent, "clear") {
    fun targets(targets: Selector? = null): RootEffectClearTargetsCommand {
        return RootEffectClearTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector? = null, effect: String? = null): RootEffectClearTargetsEffectCommand {
        return targets(targets).effect(effect)
    }
}

class RootEffectGiveTargetsEffectSecondsAmplifierHideParticlesCommand(
    parent: CommandNode,
    hideParticles: Boolean? = null
): CommandArgument(parent, hideParticles)

class RootEffectGiveTargetsEffectSecondsAmplifierCommand(
    parent: CommandNode,
    amplifier: Int? = null
): CommandArgument(parent, amplifier) {
    fun hideParticles(hideParticles: Boolean? = null): RootEffectGiveTargetsEffectSecondsAmplifierHideParticlesCommand {
        return RootEffectGiveTargetsEffectSecondsAmplifierHideParticlesCommand(this, hideParticles)
    }
}

class RootEffectGiveTargetsEffectSecondsCommand(
    parent: CommandNode,
    seconds: Int? = null
): CommandArgument(parent, seconds) {
    fun amplifier(amplifier: Int? = null): RootEffectGiveTargetsEffectSecondsAmplifierCommand {
        return RootEffectGiveTargetsEffectSecondsAmplifierCommand(this, amplifier)
    }
}

class RootEffectGiveTargetsEffectCommand(
    parent: CommandNode,
    effect: String
): CommandArgument(parent, effect) {
    fun seconds(seconds: Int? = null): RootEffectGiveTargetsEffectSecondsCommand {
        return RootEffectGiveTargetsEffectSecondsCommand(this, seconds)
    }
}

class RootEffectGiveTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun effect(effect: String): RootEffectGiveTargetsEffectCommand {
        return RootEffectGiveTargetsEffectCommand(this, effect)
    }
}

class RootEffectGiveCommand(
    parent: CommandNode
): CommandLiteral(parent, "give") {
    fun targets(targets: Selector): RootEffectGiveTargetsCommand {
        return RootEffectGiveTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, effect: String, seconds: Int? = null, amplifier: Int? = null, hideParticles: Boolean? = null): RootEffectGiveTargetsEffectSecondsAmplifierHideParticlesCommand {
        return targets(targets).effect(effect).seconds(seconds).amplifier(amplifier).hideParticles(hideParticles)
    }
}

class RootEffectCommand(
    parent: CommandNode?,
    literal: String? = "effect"
): CommandLiteral(parent, literal) {
    val clear = RootEffectClearCommand(this)
    val give = RootEffectGiveCommand(this)
}
val effect = RootEffectCommand(null)