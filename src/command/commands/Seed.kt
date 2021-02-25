package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootSeedCommand(
    parent: CommandNode?,
    literal: String? = "seed"
): CommandLiteral(parent, literal)
val seed = RootSeedCommand(null)