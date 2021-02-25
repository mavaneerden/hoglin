package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootScoreboardObjectivesAddObjectiveCriteriaDisplayNameCommand(
    parent: CommandNode,
    displayName: String? = null
): CommandArgument(parent, displayName)

class RootScoreboardObjectivesAddObjectiveCriteriaCommand(
    parent: CommandNode,
    criteria: String
): CommandArgument(parent, criteria) {
    fun displayName(displayName: String? = null): RootScoreboardObjectivesAddObjectiveCriteriaDisplayNameCommand {
        return RootScoreboardObjectivesAddObjectiveCriteriaDisplayNameCommand(this, displayName)
    }
}

class RootScoreboardObjectivesAddObjectiveCommand(
    parent: CommandNode,
    objective: String
): CommandArgument(parent, objective) {
    fun criteria(criteria: String): RootScoreboardObjectivesAddObjectiveCriteriaCommand {
        return RootScoreboardObjectivesAddObjectiveCriteriaCommand(this, criteria)
    }
}

class RootScoreboardObjectivesAddCommand(
    parent: CommandNode
): CommandLiteral(parent, "add") {
    fun objective(objective: String): RootScoreboardObjectivesAddObjectiveCommand {
        return RootScoreboardObjectivesAddObjectiveCommand(this, objective)
    }

    operator fun invoke(objective: String, criteria: String, displayName: String? = null): RootScoreboardObjectivesAddObjectiveCriteriaDisplayNameCommand {
        return objective(objective).criteria(criteria).displayName(displayName)
    }
}

class RootScoreboardObjectivesListCommand(
    parent: CommandNode
): CommandLiteral(parent, "list")

class RootScoreboardObjectivesModifyObjectiveDisplaynameDisplayNameCommand(
    parent: CommandNode,
    displayName: String
): CommandArgument(parent, displayName)

class RootScoreboardObjectivesModifyObjectiveDisplaynameCommand(
    parent: CommandNode
): CommandLiteral(parent, "displayname") {
    fun displayName(displayName: String): RootScoreboardObjectivesModifyObjectiveDisplaynameDisplayNameCommand {
        return RootScoreboardObjectivesModifyObjectiveDisplaynameDisplayNameCommand(this, displayName)
    }

    operator fun invoke(displayName: String): RootScoreboardObjectivesModifyObjectiveDisplaynameDisplayNameCommand {
        return displayName(displayName)
    }
}

class RootScoreboardObjectivesModifyObjectiveRendertypeHeartsCommand(
    parent: CommandNode
): CommandLiteral(parent, "hearts")

class RootScoreboardObjectivesModifyObjectiveRendertypeIntegerCommand(
    parent: CommandNode
): CommandLiteral(parent, "integer")

class RootScoreboardObjectivesModifyObjectiveRendertypeCommand(
    parent: CommandNode
): CommandLiteral(parent, "rendertype") {
    val hearts = RootScoreboardObjectivesModifyObjectiveRendertypeHeartsCommand(this)
    val integer = RootScoreboardObjectivesModifyObjectiveRendertypeIntegerCommand(this)
}

class RootScoreboardObjectivesModifyObjectiveCommand(
    parent: CommandNode,
    objective: String
): CommandArgument(parent, objective) {
    val displayname = RootScoreboardObjectivesModifyObjectiveDisplaynameCommand(this)
    val rendertype = RootScoreboardObjectivesModifyObjectiveRendertypeCommand(this)
}

class RootScoreboardObjectivesModifyCommand(
    parent: CommandNode
): CommandLiteral(parent, "modify") {
    fun objective(objective: String): RootScoreboardObjectivesModifyObjectiveCommand {
        return RootScoreboardObjectivesModifyObjectiveCommand(this, objective)
    }

    operator fun invoke(objective: String): RootScoreboardObjectivesModifyObjectiveCommand {
        return objective(objective)
    }
}

class RootScoreboardObjectivesRemoveObjectiveCommand(
    parent: CommandNode,
    objective: String
): CommandArgument(parent, objective)

class RootScoreboardObjectivesRemoveCommand(
    parent: CommandNode
): CommandLiteral(parent, "remove") {
    fun objective(objective: String): RootScoreboardObjectivesRemoveObjectiveCommand {
        return RootScoreboardObjectivesRemoveObjectiveCommand(this, objective)
    }

    operator fun invoke(objective: String): RootScoreboardObjectivesRemoveObjectiveCommand {
        return objective(objective)
    }
}

class RootScoreboardObjectivesSetdisplaySlotObjectiveCommand(
    parent: CommandNode,
    objective: String? = null
): CommandArgument(parent, objective)

class RootScoreboardObjectivesSetdisplaySlotCommand(
    parent: CommandNode,
    slot: String
): CommandArgument(parent, slot) {
    fun objective(objective: String? = null): RootScoreboardObjectivesSetdisplaySlotObjectiveCommand {
        return RootScoreboardObjectivesSetdisplaySlotObjectiveCommand(this, objective)
    }
}

class RootScoreboardObjectivesSetdisplayCommand(
    parent: CommandNode
): CommandLiteral(parent, "setdisplay") {
    fun slot(slot: String): RootScoreboardObjectivesSetdisplaySlotCommand {
        return RootScoreboardObjectivesSetdisplaySlotCommand(this, slot)
    }

    operator fun invoke(slot: String, objective: String? = null): RootScoreboardObjectivesSetdisplaySlotObjectiveCommand {
        return slot(slot).objective(objective)
    }
}

class RootScoreboardObjectivesCommand(
    parent: CommandNode
): CommandLiteral(parent, "objectives") {
    val add = RootScoreboardObjectivesAddCommand(this)
    val list = RootScoreboardObjectivesListCommand(this)
    val modify = RootScoreboardObjectivesModifyCommand(this)
    val remove = RootScoreboardObjectivesRemoveCommand(this)
    val setdisplay = RootScoreboardObjectivesSetdisplayCommand(this)
}

class RootScoreboardPlayersAddTargetsObjectiveScoreCommand(
    parent: CommandNode,
    score: Int
): CommandArgument(parent, score)

class RootScoreboardPlayersAddTargetsObjectiveCommand(
    parent: CommandNode,
    objective: String
): CommandArgument(parent, objective) {
    fun score(score: Int): RootScoreboardPlayersAddTargetsObjectiveScoreCommand {
        return RootScoreboardPlayersAddTargetsObjectiveScoreCommand(this, score)
    }
}

class RootScoreboardPlayersAddTargetsCommand(
    parent: CommandNode,
    targets: String
): CommandArgument(parent, targets) {
    fun objective(objective: String): RootScoreboardPlayersAddTargetsObjectiveCommand {
        return RootScoreboardPlayersAddTargetsObjectiveCommand(this, objective)
    }
}

class RootScoreboardPlayersAddCommand(
    parent: CommandNode
): CommandLiteral(parent, "add") {
    fun targets(targets: String): RootScoreboardPlayersAddTargetsCommand {
        return RootScoreboardPlayersAddTargetsCommand(this, targets)
    }

    operator fun invoke(targets: String, objective: String, score: Int): RootScoreboardPlayersAddTargetsObjectiveScoreCommand {
        return targets(targets).objective(objective).score(score)
    }
}

class RootScoreboardPlayersEnableTargetsObjectiveCommand(
    parent: CommandNode,
    objective: String
): CommandArgument(parent, objective)

class RootScoreboardPlayersEnableTargetsCommand(
    parent: CommandNode,
    targets: String
): CommandArgument(parent, targets) {
    fun objective(objective: String): RootScoreboardPlayersEnableTargetsObjectiveCommand {
        return RootScoreboardPlayersEnableTargetsObjectiveCommand(this, objective)
    }
}

class RootScoreboardPlayersEnableCommand(
    parent: CommandNode
): CommandLiteral(parent, "enable") {
    fun targets(targets: String): RootScoreboardPlayersEnableTargetsCommand {
        return RootScoreboardPlayersEnableTargetsCommand(this, targets)
    }

    operator fun invoke(targets: String, objective: String): RootScoreboardPlayersEnableTargetsObjectiveCommand {
        return targets(targets).objective(objective)
    }
}

class RootScoreboardPlayersGetTargetObjectiveCommand(
    parent: CommandNode,
    objective: String
): CommandArgument(parent, objective)

class RootScoreboardPlayersGetTargetCommand(
    parent: CommandNode,
    target: String
): CommandArgument(parent, target) {
    fun objective(objective: String): RootScoreboardPlayersGetTargetObjectiveCommand {
        return RootScoreboardPlayersGetTargetObjectiveCommand(this, objective)
    }
}

class RootScoreboardPlayersGetCommand(
    parent: CommandNode
): CommandLiteral(parent, "get") {
    fun target(target: String): RootScoreboardPlayersGetTargetCommand {
        return RootScoreboardPlayersGetTargetCommand(this, target)
    }

    operator fun invoke(target: String, objective: String): RootScoreboardPlayersGetTargetObjectiveCommand {
        return target(target).objective(objective)
    }
}

class RootScoreboardPlayersListTargetCommand(
    parent: CommandNode,
    target: String? = null
): CommandArgument(parent, target)

class RootScoreboardPlayersListCommand(
    parent: CommandNode
): CommandLiteral(parent, "list") {
    fun target(target: String? = null): RootScoreboardPlayersListTargetCommand {
        return RootScoreboardPlayersListTargetCommand(this, target)
    }

    operator fun invoke(target: String? = null): RootScoreboardPlayersListTargetCommand {
        return target(target)
    }
}

class RootScoreboardPlayersOperationTargetsTargetObjectiveOperationSourceSourceObjectiveCommand(
    parent: CommandNode,
    sourceObjective: String
): CommandArgument(parent, sourceObjective)

class RootScoreboardPlayersOperationTargetsTargetObjectiveOperationSourceCommand(
    parent: CommandNode,
    source: String
): CommandArgument(parent, source) {
    fun sourceObjective(sourceObjective: String): RootScoreboardPlayersOperationTargetsTargetObjectiveOperationSourceSourceObjectiveCommand {
        return RootScoreboardPlayersOperationTargetsTargetObjectiveOperationSourceSourceObjectiveCommand(this, sourceObjective)
    }
}

class RootScoreboardPlayersOperationTargetsTargetObjectiveOperationCommand(
    parent: CommandNode,
    operation: String
): CommandArgument(parent, operation) {
    fun source(source: String): RootScoreboardPlayersOperationTargetsTargetObjectiveOperationSourceCommand {
        return RootScoreboardPlayersOperationTargetsTargetObjectiveOperationSourceCommand(this, source)
    }
}

class RootScoreboardPlayersOperationTargetsTargetObjectiveCommand(
    parent: CommandNode,
    targetObjective: String
): CommandArgument(parent, targetObjective) {
    fun operation(operation: String): RootScoreboardPlayersOperationTargetsTargetObjectiveOperationCommand {
        return RootScoreboardPlayersOperationTargetsTargetObjectiveOperationCommand(this, operation)
    }
}

class RootScoreboardPlayersOperationTargetsCommand(
    parent: CommandNode,
    targets: String
): CommandArgument(parent, targets) {
    fun targetObjective(targetObjective: String): RootScoreboardPlayersOperationTargetsTargetObjectiveCommand {
        return RootScoreboardPlayersOperationTargetsTargetObjectiveCommand(this, targetObjective)
    }
}

class RootScoreboardPlayersOperationCommand(
    parent: CommandNode
): CommandLiteral(parent, "operation") {
    fun targets(targets: String): RootScoreboardPlayersOperationTargetsCommand {
        return RootScoreboardPlayersOperationTargetsCommand(this, targets)
    }

    operator fun invoke(targets: String, targetObjective: String, operation: String, source: String, sourceObjective: String): RootScoreboardPlayersOperationTargetsTargetObjectiveOperationSourceSourceObjectiveCommand {
        return targets(targets).targetObjective(targetObjective).operation(operation).source(source).sourceObjective(sourceObjective)
    }
}

class RootScoreboardPlayersRemoveTargetsObjectiveScoreCommand(
    parent: CommandNode,
    score: Int
): CommandArgument(parent, score)

class RootScoreboardPlayersRemoveTargetsObjectiveCommand(
    parent: CommandNode,
    objective: String
): CommandArgument(parent, objective) {
    fun score(score: Int): RootScoreboardPlayersRemoveTargetsObjectiveScoreCommand {
        return RootScoreboardPlayersRemoveTargetsObjectiveScoreCommand(this, score)
    }
}

class RootScoreboardPlayersRemoveTargetsCommand(
    parent: CommandNode,
    targets: String
): CommandArgument(parent, targets) {
    fun objective(objective: String): RootScoreboardPlayersRemoveTargetsObjectiveCommand {
        return RootScoreboardPlayersRemoveTargetsObjectiveCommand(this, objective)
    }
}

class RootScoreboardPlayersRemoveCommand(
    parent: CommandNode
): CommandLiteral(parent, "remove") {
    fun targets(targets: String): RootScoreboardPlayersRemoveTargetsCommand {
        return RootScoreboardPlayersRemoveTargetsCommand(this, targets)
    }

    operator fun invoke(targets: String, objective: String, score: Int): RootScoreboardPlayersRemoveTargetsObjectiveScoreCommand {
        return targets(targets).objective(objective).score(score)
    }
}

class RootScoreboardPlayersResetTargetsObjectiveCommand(
    parent: CommandNode,
    objective: String? = null
): CommandArgument(parent, objective)

class RootScoreboardPlayersResetTargetsCommand(
    parent: CommandNode,
    targets: String
): CommandArgument(parent, targets) {
    fun objective(objective: String? = null): RootScoreboardPlayersResetTargetsObjectiveCommand {
        return RootScoreboardPlayersResetTargetsObjectiveCommand(this, objective)
    }
}

class RootScoreboardPlayersResetCommand(
    parent: CommandNode
): CommandLiteral(parent, "reset") {
    fun targets(targets: String): RootScoreboardPlayersResetTargetsCommand {
        return RootScoreboardPlayersResetTargetsCommand(this, targets)
    }

    operator fun invoke(targets: String, objective: String? = null): RootScoreboardPlayersResetTargetsObjectiveCommand {
        return targets(targets).objective(objective)
    }
}

class RootScoreboardPlayersSetTargetsObjectiveScoreCommand(
    parent: CommandNode,
    score: Int
): CommandArgument(parent, score)

class RootScoreboardPlayersSetTargetsObjectiveCommand(
    parent: CommandNode,
    objective: String
): CommandArgument(parent, objective) {
    fun score(score: Int): RootScoreboardPlayersSetTargetsObjectiveScoreCommand {
        return RootScoreboardPlayersSetTargetsObjectiveScoreCommand(this, score)
    }
}

class RootScoreboardPlayersSetTargetsCommand(
    parent: CommandNode,
    targets: String
): CommandArgument(parent, targets) {
    fun objective(objective: String): RootScoreboardPlayersSetTargetsObjectiveCommand {
        return RootScoreboardPlayersSetTargetsObjectiveCommand(this, objective)
    }
}

class RootScoreboardPlayersSetCommand(
    parent: CommandNode
): CommandLiteral(parent, "set") {
    fun targets(targets: String): RootScoreboardPlayersSetTargetsCommand {
        return RootScoreboardPlayersSetTargetsCommand(this, targets)
    }

    operator fun invoke(targets: String, objective: String, score: Int): RootScoreboardPlayersSetTargetsObjectiveScoreCommand {
        return targets(targets).objective(objective).score(score)
    }
}

class RootScoreboardPlayersCommand(
    parent: CommandNode
): CommandLiteral(parent, "players") {
    val add = RootScoreboardPlayersAddCommand(this)
    val enable = RootScoreboardPlayersEnableCommand(this)
    val get = RootScoreboardPlayersGetCommand(this)
    val list = RootScoreboardPlayersListCommand(this)
    val operation = RootScoreboardPlayersOperationCommand(this)
    val remove = RootScoreboardPlayersRemoveCommand(this)
    val reset = RootScoreboardPlayersResetCommand(this)
    val set = RootScoreboardPlayersSetCommand(this)
}

class RootScoreboardCommand(
    parent: CommandNode?,
    literal: String? = "scoreboard"
): CommandLiteral(parent, literal) {
    val objectives = RootScoreboardObjectivesCommand(this)
    val players = RootScoreboardPlayersCommand(this)
}
val scoreboard = RootScoreboardCommand(null)