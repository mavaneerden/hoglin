package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootWCommand(
    parent: CommandNode?,
    literal: String? = "w"
): RootMsgCommandRedirect(parent, literal)
val w = RootWCommand(null).redirect()