package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootDefaultgamemodeAdventureCommand(
    parent: CommandNode
): CommandLiteral(parent, "adventure")

class RootDefaultgamemodeCreativeCommand(
    parent: CommandNode
): CommandLiteral(parent, "creative")

class RootDefaultgamemodeSpectatorCommand(
    parent: CommandNode
): CommandLiteral(parent, "spectator")

class RootDefaultgamemodeSurvivalCommand(
    parent: CommandNode
): CommandLiteral(parent, "survival")

class RootDefaultgamemodeCommand(
    parent: CommandNode?,
    literal: String? = "defaultgamemode"
): CommandLiteral(parent, literal) {
    val adventure = RootDefaultgamemodeAdventureCommand(this)
    val creative = RootDefaultgamemodeCreativeCommand(this)
    val spectator = RootDefaultgamemodeSpectatorCommand(this)
    val survival = RootDefaultgamemodeSurvivalCommand(this)
}
val defaultgamemode = RootDefaultgamemodeCommand(null)