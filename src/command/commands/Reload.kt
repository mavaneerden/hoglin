package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootReloadCommand(
    parent: CommandNode?,
    literal: String? = "reload"
): CommandLiteral(parent, literal)
val reload = RootReloadCommand(null)