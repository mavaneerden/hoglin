package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootBanlistIpsCommand(
    parent: CommandNode,
    literal: String? = "ips"
): CommandLiteral(parent, literal)

class RootBanlistPlayersCommand(
    parent: CommandNode,
    literal: String? = "players"
): CommandLiteral(parent, literal)

class RootBanlistCommand(
    parent: CommandNode?,
    literal: String? = "banlist"
): CommandLiteral(parent, literal) {
    val ips = RootBanlistIpsCommand(this)
    val players = RootBanlistPlayersCommand(this)
}
val banlist = RootBanlistCommand(null)