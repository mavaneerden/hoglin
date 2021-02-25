package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootSetidletimeoutMinutesCommand(
    parent: CommandNode,
    minutes: Int
): CommandArgument(parent, minutes)

class RootSetidletimeoutCommand(
    parent: CommandNode?,
    literal: String? = "setidletimeout"
): CommandLiteral(parent, literal) {
    fun minutes(minutes: Int): RootSetidletimeoutMinutesCommand {
        return RootSetidletimeoutMinutesCommand(this, minutes)
    }

    operator fun invoke(minutes: Int): RootSetidletimeoutMinutesCommand {
        return minutes(minutes)
    }
}
val setidletimeout = RootSetidletimeoutCommand(null)