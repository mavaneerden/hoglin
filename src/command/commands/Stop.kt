package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootStopCommand(
    parent: CommandNode?,
    literal: String? = "stop"
): CommandLiteral(parent, literal)
val stop = RootStopCommand(null)