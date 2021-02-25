package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootLocatebiomeBiomeCommand(
    parent: CommandNode,
    biome: String
): CommandArgument(parent, biome)

class RootLocatebiomeCommand(
    parent: CommandNode?,
    literal: String? = "locatebiome"
): CommandLiteral(parent, literal) {
    fun biome(biome: String): RootLocatebiomeBiomeCommand {
        return RootLocatebiomeBiomeCommand(this, biome)
    }

    operator fun invoke(biome: String): RootLocatebiomeBiomeCommand {
        return biome(biome)
    }
}
val locatebiome = RootLocatebiomeCommand(null)