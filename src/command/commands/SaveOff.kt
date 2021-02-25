package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootSaveOffCommand(
    parent: CommandNode?,
    literal: String? = "save-off"
): CommandLiteral(parent, literal)
val saveOff = RootSaveOffCommand(null)