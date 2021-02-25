package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootSpreadplayersCenterSpreadDistanceMaxRangeUnderMaxHeightRespectTeamsTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets)

class RootSpreadplayersCenterSpreadDistanceMaxRangeUnderMaxHeightRespectTeamsCommand(
    parent: CommandNode,
    respectTeams: Boolean
): CommandArgument(parent, respectTeams) {
    fun targets(targets: Selector): RootSpreadplayersCenterSpreadDistanceMaxRangeUnderMaxHeightRespectTeamsTargetsCommand {
        return RootSpreadplayersCenterSpreadDistanceMaxRangeUnderMaxHeightRespectTeamsTargetsCommand(this, targets)
    }
}

class RootSpreadplayersCenterSpreadDistanceMaxRangeUnderMaxHeightCommand(
    parent: CommandNode,
    maxHeight: Int
): CommandArgument(parent, maxHeight) {
    fun respectTeams(respectTeams: Boolean): RootSpreadplayersCenterSpreadDistanceMaxRangeUnderMaxHeightRespectTeamsCommand {
        return RootSpreadplayersCenterSpreadDistanceMaxRangeUnderMaxHeightRespectTeamsCommand(this, respectTeams)
    }
}

class RootSpreadplayersCenterSpreadDistanceMaxRangeUnderCommand(
    parent: CommandNode
): CommandLiteral(parent, "under") {
    fun maxHeight(maxHeight: Int): RootSpreadplayersCenterSpreadDistanceMaxRangeUnderMaxHeightCommand {
        return RootSpreadplayersCenterSpreadDistanceMaxRangeUnderMaxHeightCommand(this, maxHeight)
    }

    operator fun invoke(maxHeight: Int, respectTeams: Boolean, targets: Selector): RootSpreadplayersCenterSpreadDistanceMaxRangeUnderMaxHeightRespectTeamsTargetsCommand {
        return maxHeight(maxHeight).respectTeams(respectTeams).targets(targets)
    }
}

class RootSpreadplayersCenterSpreadDistanceMaxRangeRespectTeamsTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets)

class RootSpreadplayersCenterSpreadDistanceMaxRangeRespectTeamsCommand(
    parent: CommandNode,
    respectTeams: Boolean
): CommandArgument(parent, respectTeams) {
    fun targets(targets: Selector): RootSpreadplayersCenterSpreadDistanceMaxRangeRespectTeamsTargetsCommand {
        return RootSpreadplayersCenterSpreadDistanceMaxRangeRespectTeamsTargetsCommand(this, targets)
    }
}

class RootSpreadplayersCenterSpreadDistanceMaxRangeCommand(
    parent: CommandNode,
    maxRange: Float
): CommandArgument(parent, maxRange) {
    val under = RootSpreadplayersCenterSpreadDistanceMaxRangeUnderCommand(this)

        fun respectTeams(respectTeams: Boolean): RootSpreadplayersCenterSpreadDistanceMaxRangeRespectTeamsCommand {
        return RootSpreadplayersCenterSpreadDistanceMaxRangeRespectTeamsCommand(this, respectTeams)
    }
}

class RootSpreadplayersCenterSpreadDistanceCommand(
    parent: CommandNode,
    spreadDistance: Float
): CommandArgument(parent, spreadDistance) {
    fun maxRange(maxRange: Float): RootSpreadplayersCenterSpreadDistanceMaxRangeCommand {
        return RootSpreadplayersCenterSpreadDistanceMaxRangeCommand(this, maxRange)
    }
}

class RootSpreadplayersCenterCommand(
    parent: CommandNode,
    center: String
): CommandArgument(parent, center) {
    fun spreadDistance(spreadDistance: Float): RootSpreadplayersCenterSpreadDistanceCommand {
        return RootSpreadplayersCenterSpreadDistanceCommand(this, spreadDistance)
    }
}

class RootSpreadplayersCommand(
    parent: CommandNode?,
    literal: String? = "spreadplayers"
): CommandLiteral(parent, literal) {
    fun center(center: String): RootSpreadplayersCenterCommand {
        return RootSpreadplayersCenterCommand(this, center)
    }

    operator fun invoke(center: String, spreadDistance: Float, maxRange: Float): RootSpreadplayersCenterSpreadDistanceMaxRangeCommand {
        return center(center).spreadDistance(spreadDistance).maxRange(maxRange)
    }

    operator fun invoke(center: String, spreadDistance: Float, maxRange: Float, respectTeams: Boolean, targets: Selector): RootSpreadplayersCenterSpreadDistanceMaxRangeRespectTeamsTargetsCommand {
        return center(center).spreadDistance(spreadDistance).maxRange(maxRange).respectTeams(respectTeams).targets(targets)
    }
}
val spreadplayers = RootSpreadplayersCommand(null)