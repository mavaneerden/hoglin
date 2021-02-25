package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootWeatherClearDurationCommand(
    parent: CommandNode,
    duration: Int? = null
): CommandArgument(parent, duration)

class RootWeatherClearCommand(
    parent: CommandNode
): CommandLiteral(parent, "clear") {
    fun duration(duration: Int? = null): RootWeatherClearDurationCommand {
        return RootWeatherClearDurationCommand(this, duration)
    }

    operator fun invoke(duration: Int? = null): RootWeatherClearDurationCommand {
        return duration(duration)
    }
}

class RootWeatherRainDurationCommand(
    parent: CommandNode,
    duration: Int? = null
): CommandArgument(parent, duration)

class RootWeatherRainCommand(
    parent: CommandNode
): CommandLiteral(parent, "rain") {
    fun duration(duration: Int? = null): RootWeatherRainDurationCommand {
        return RootWeatherRainDurationCommand(this, duration)
    }

    operator fun invoke(duration: Int? = null): RootWeatherRainDurationCommand {
        return duration(duration)
    }
}

class RootWeatherThunderDurationCommand(
    parent: CommandNode,
    duration: Int? = null
): CommandArgument(parent, duration)

class RootWeatherThunderCommand(
    parent: CommandNode
): CommandLiteral(parent, "thunder") {
    fun duration(duration: Int? = null): RootWeatherThunderDurationCommand {
        return RootWeatherThunderDurationCommand(this, duration)
    }

    operator fun invoke(duration: Int? = null): RootWeatherThunderDurationCommand {
        return duration(duration)
    }
}

class RootWeatherCommand(
    parent: CommandNode?,
    literal: String? = "weather"
): CommandLiteral(parent, literal) {
    val clear = RootWeatherClearCommand(this)
    val rain = RootWeatherRainCommand(this)
    val thunder = RootWeatherThunderCommand(this)
}
val weather = RootWeatherCommand(null)