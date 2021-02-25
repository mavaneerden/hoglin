package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootSaveOnCommand(
    parent: CommandNode?,
    literal: String? = "save-on"
): CommandLiteral(parent, literal)
val saveOn = RootSaveOnCommand(null)