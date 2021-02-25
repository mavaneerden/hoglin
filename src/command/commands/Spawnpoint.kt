package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootSpawnpointTargetsPosAngleCommand(
    parent: CommandNode,
    angle: Float? = null
): CommandArgument(parent, angle)

class RootSpawnpointTargetsPosCommand(
    parent: CommandNode,
    pos: String? = null
): CommandArgument(parent, pos) {
    fun angle(angle: Float? = null): RootSpawnpointTargetsPosAngleCommand {
        return RootSpawnpointTargetsPosAngleCommand(this, angle)
    }
}

class RootSpawnpointTargetsCommand(
    parent: CommandNode,
    targets: Selector? = null
): CommandArgument(parent, targets) {
    fun pos(pos: String? = null): RootSpawnpointTargetsPosCommand {
        return RootSpawnpointTargetsPosCommand(this, pos)
    }
}

class RootSpawnpointCommand(
    parent: CommandNode?,
    literal: String? = "spawnpoint"
): CommandLiteral(parent, literal) {
    fun targets(targets: Selector? = null): RootSpawnpointTargetsCommand {
        return RootSpawnpointTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector? = null, pos: String? = null, angle: Float? = null): RootSpawnpointTargetsPosAngleCommand {
        return targets(targets).pos(pos).angle(angle)
    }
}
val spawnpoint = RootSpawnpointCommand(null)