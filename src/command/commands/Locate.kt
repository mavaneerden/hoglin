package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootLocateBastionRemnantCommand(
    parent: CommandNode
): CommandLiteral(parent, "bastion_remnant")

class RootLocateBuriedTreasureCommand(
    parent: CommandNode
): CommandLiteral(parent, "buried_treasure")

class RootLocateDesertPyramidCommand(
    parent: CommandNode
): CommandLiteral(parent, "desert_pyramid")

class RootLocateEndcityCommand(
    parent: CommandNode
): CommandLiteral(parent, "endcity")

class RootLocateFortressCommand(
    parent: CommandNode
): CommandLiteral(parent, "fortress")

class RootLocateIglooCommand(
    parent: CommandNode
): CommandLiteral(parent, "igloo")

class RootLocateJunglePyramidCommand(
    parent: CommandNode
): CommandLiteral(parent, "jungle_pyramid")

class RootLocateMansionCommand(
    parent: CommandNode
): CommandLiteral(parent, "mansion")

class RootLocateMineshaftCommand(
    parent: CommandNode
): CommandLiteral(parent, "mineshaft")

class RootLocateMonumentCommand(
    parent: CommandNode
): CommandLiteral(parent, "monument")

class RootLocateNetherFossilCommand(
    parent: CommandNode
): CommandLiteral(parent, "nether_fossil")

class RootLocateOceanRuinCommand(
    parent: CommandNode
): CommandLiteral(parent, "ocean_ruin")

class RootLocatePillagerOutpostCommand(
    parent: CommandNode
): CommandLiteral(parent, "pillager_outpost")

class RootLocateRuinedPortalCommand(
    parent: CommandNode
): CommandLiteral(parent, "ruined_portal")

class RootLocateShipwreckCommand(
    parent: CommandNode
): CommandLiteral(parent, "shipwreck")

class RootLocateStrongholdCommand(
    parent: CommandNode
): CommandLiteral(parent, "stronghold")

class RootLocateSwampHutCommand(
    parent: CommandNode
): CommandLiteral(parent, "swamp_hut")

class RootLocateVillageCommand(
    parent: CommandNode
): CommandLiteral(parent, "village")

class RootLocateCommand(
    parent: CommandNode?,
    literal: String? = "locate"
): CommandLiteral(parent, literal) {
    val bastionRemnant = RootLocateBastionRemnantCommand(this)
    val buriedTreasure = RootLocateBuriedTreasureCommand(this)
    val desertPyramid = RootLocateDesertPyramidCommand(this)
    val endcity = RootLocateEndcityCommand(this)
    val fortress = RootLocateFortressCommand(this)
    val igloo = RootLocateIglooCommand(this)
    val junglePyramid = RootLocateJunglePyramidCommand(this)
    val mansion = RootLocateMansionCommand(this)
    val mineshaft = RootLocateMineshaftCommand(this)
    val monument = RootLocateMonumentCommand(this)
    val netherFossil = RootLocateNetherFossilCommand(this)
    val oceanRuin = RootLocateOceanRuinCommand(this)
    val pillagerOutpost = RootLocatePillagerOutpostCommand(this)
    val ruinedPortal = RootLocateRuinedPortalCommand(this)
    val shipwreck = RootLocateShipwreckCommand(this)
    val stronghold = RootLocateStrongholdCommand(this)
    val swampHut = RootLocateSwampHutCommand(this)
    val village = RootLocateVillageCommand(this)
}
val locate = RootLocateCommand(null)