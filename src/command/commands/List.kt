package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootListUuidsCommand(
    parent: CommandNode,
    literal: String? = "uuids"
): CommandLiteral(parent, literal)

class RootListCommand(
    parent: CommandNode?,
    literal: String? = "list"
): CommandLiteral(parent, literal) {
    val uuids = RootListUuidsCommand(this)
}
val list = RootListCommand(null)