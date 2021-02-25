package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootSaveAllFlushCommand(
    parent: CommandNode,
    literal: String? = "flush"
): CommandLiteral(parent, literal)

class RootSaveAllCommand(
    parent: CommandNode?,
    literal: String? = "save-all"
): CommandLiteral(parent, literal) {
    val flush = RootSaveAllFlushCommand(this)
}
val saveAll = RootSaveAllCommand(null)