package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootTimeAddTimeCommand(
    parent: CommandNode,
    time: String
): CommandArgument(parent, time)

class RootTimeAddCommand(
    parent: CommandNode
): CommandLiteral(parent, "add") {
    fun time(time: String): RootTimeAddTimeCommand {
        return RootTimeAddTimeCommand(this, time)
    }

    operator fun invoke(time: String): RootTimeAddTimeCommand {
        return time(time)
    }
}

class RootTimeQueryDayCommand(
    parent: CommandNode
): CommandLiteral(parent, "day")

class RootTimeQueryDaytimeCommand(
    parent: CommandNode
): CommandLiteral(parent, "daytime")

class RootTimeQueryGametimeCommand(
    parent: CommandNode
): CommandLiteral(parent, "gametime")

class RootTimeQueryCommand(
    parent: CommandNode
): CommandLiteral(parent, "query") {
    val day = RootTimeQueryDayCommand(this)
    val daytime = RootTimeQueryDaytimeCommand(this)
    val gametime = RootTimeQueryGametimeCommand(this)
}

class RootTimeSetDayCommand(
    parent: CommandNode
): CommandLiteral(parent, "day")

class RootTimeSetMidnightCommand(
    parent: CommandNode
): CommandLiteral(parent, "midnight")

class RootTimeSetNightCommand(
    parent: CommandNode
): CommandLiteral(parent, "night")

class RootTimeSetNoonCommand(
    parent: CommandNode
): CommandLiteral(parent, "noon")

class RootTimeSetTimeCommand(
    parent: CommandNode,
    time: String
): CommandArgument(parent, time)

class RootTimeSetCommand(
    parent: CommandNode
): CommandLiteral(parent, "set") {
    val day = RootTimeSetDayCommand(this)
    val midnight = RootTimeSetMidnightCommand(this)
    val night = RootTimeSetNightCommand(this)
    val noon = RootTimeSetNoonCommand(this)

        fun time(time: String): RootTimeSetTimeCommand {
        return RootTimeSetTimeCommand(this, time)
    }

    operator fun invoke(time: String): RootTimeSetTimeCommand {
        return time(time)
    }
}

class RootTimeCommand(
    parent: CommandNode?,
    literal: String? = "time"
): CommandLiteral(parent, literal) {
    val add = RootTimeAddCommand(this)
    val query = RootTimeQueryCommand(this)
    val set = RootTimeSetCommand(this)
}
val time = RootTimeCommand(null)