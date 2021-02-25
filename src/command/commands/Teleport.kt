package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootTeleportDestinationCommand(
    parent: CommandNode,
    destination: Selector
): CommandArgument(parent, destination)

class RootTeleportLocationCommand(
    parent: CommandNode,
    location: Coordinates
): CommandArgument(parent, location)

class RootTeleportTargetsDestinationCommand(
    parent: CommandNode,
    destination: Selector
): CommandArgument(parent, destination)

class RootTeleportTargetsLocationFacingEntityFacingEntityFacingAnchorCommand(
    parent: CommandNode,
    facingAnchor: String? = null
): CommandArgument(parent, facingAnchor)

class RootTeleportTargetsLocationFacingEntityFacingEntityCommand(
    parent: CommandNode,
    facingEntity: Selector? = null
): CommandArgument(parent, facingEntity) {
    fun facingAnchor(facingAnchor: String? = null): RootTeleportTargetsLocationFacingEntityFacingEntityFacingAnchorCommand {
        return RootTeleportTargetsLocationFacingEntityFacingEntityFacingAnchorCommand(this, facingAnchor)
    }
}

class RootTeleportTargetsLocationFacingEntityCommand(
    parent: CommandNode,
    literal: String? = "entity"
): CommandLiteral(parent, literal) {
    fun facingEntity(facingEntity: Selector? = null): RootTeleportTargetsLocationFacingEntityFacingEntityCommand {
        return RootTeleportTargetsLocationFacingEntityFacingEntityCommand(this, facingEntity)
    }

    operator fun invoke(facingEntity: Selector? = null, facingAnchor: String? = null): RootTeleportTargetsLocationFacingEntityFacingEntityFacingAnchorCommand {
        return facingEntity(facingEntity).facingAnchor(facingAnchor)
    }
}

class RootTeleportTargetsLocationFacingFacingLocationCommand(
    parent: CommandNode,
    facingLocation: Coordinates? = null
): CommandArgument(parent, facingLocation)

class RootTeleportTargetsLocationFacingCommand(
    parent: CommandNode,
    literal: String? = "facing"
): CommandLiteral(parent, literal) {
    val entity = RootTeleportTargetsLocationFacingEntityCommand(this)

        fun facingLocation(facingLocation: Coordinates? = null): RootTeleportTargetsLocationFacingFacingLocationCommand {
        return RootTeleportTargetsLocationFacingFacingLocationCommand(this, facingLocation)
    }

    operator fun invoke(facingLocation: Coordinates? = null): RootTeleportTargetsLocationFacingFacingLocationCommand {
        return facingLocation(facingLocation)
    }
}

class RootTeleportTargetsLocationRotationCommand(
    parent: CommandNode,
    rotation: String? = null
): CommandArgument(parent, rotation)

class RootTeleportTargetsLocationCommand(
    parent: CommandNode,
    location: Coordinates
): CommandArgument(parent, location) {
    val facing = RootTeleportTargetsLocationFacingCommand(this)

        fun rotation(rotation: String? = null): RootTeleportTargetsLocationRotationCommand {
        return RootTeleportTargetsLocationRotationCommand(this, rotation)
    }
}

class RootTeleportTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun destination(destination: Selector): RootTeleportTargetsDestinationCommand {
        return RootTeleportTargetsDestinationCommand(this, destination)
    }

    fun location(location: Coordinates): RootTeleportTargetsLocationCommand {
        return RootTeleportTargetsLocationCommand(this, location)
    }
}

class RootTeleportCommand(
    parent: CommandNode?,
    literal: String? = "teleport"
): CommandLiteral(parent, literal) {
    fun destination(destination: Selector): RootTeleportDestinationCommand {
        return RootTeleportDestinationCommand(this, destination)
    }

    fun location(location: Coordinates): RootTeleportLocationCommand {
        return RootTeleportLocationCommand(this, location)
    }

    fun targets(targets: Selector): RootTeleportTargetsCommand {
        return RootTeleportTargetsCommand(this, targets)
    }

    operator fun invoke(destination: Selector): RootTeleportDestinationCommand {
        return destination(destination)
    }

    operator fun invoke(location: Coordinates): RootTeleportLocationCommand {
        return location(location)
    }

    operator fun invoke(targets: Selector, destination: Selector): RootTeleportTargetsDestinationCommand {
        return targets(targets).destination(destination)
    }

    operator fun invoke(targets: Selector, location: Coordinates): RootTeleportTargetsLocationCommand {
        return targets(targets).location(location)
    }

    operator fun invoke(targets: Selector, location: Coordinates, rotation: String? = null): RootTeleportTargetsLocationRotationCommand {
        return targets(targets).location(location).rotation(rotation)
    }
}
val teleport = RootTeleportCommand(null)