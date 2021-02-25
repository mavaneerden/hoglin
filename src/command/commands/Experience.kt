package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootExperienceAddTargetsAmountLevelsCommand(
    parent: CommandNode,
    literal: String? = "levels"
): CommandLiteral(parent, literal)

class RootExperienceAddTargetsAmountPointsCommand(
    parent: CommandNode,
    literal: String? = "points"
): CommandLiteral(parent, literal)

class RootExperienceAddTargetsAmountCommand(
    parent: CommandNode,
    amount: Int
): CommandArgument(parent, amount) {
    val levels = RootExperienceAddTargetsAmountLevelsCommand(this)
    val points = RootExperienceAddTargetsAmountPointsCommand(this)
}

class RootExperienceAddTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun amount(amount: Int): RootExperienceAddTargetsAmountCommand {
        return RootExperienceAddTargetsAmountCommand(this, amount)
    }
}

class RootExperienceAddCommand(
    parent: CommandNode
): CommandLiteral(parent, "add") {
    fun targets(targets: Selector): RootExperienceAddTargetsCommand {
        return RootExperienceAddTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, amount: Int): RootExperienceAddTargetsAmountCommand {
        return targets(targets).amount(amount)
    }
}

class RootExperienceQueryTargetsLevelsCommand(
    parent: CommandNode
): CommandLiteral(parent, "levels")

class RootExperienceQueryTargetsPointsCommand(
    parent: CommandNode
): CommandLiteral(parent, "points")

class RootExperienceQueryTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    val levels = RootExperienceQueryTargetsLevelsCommand(this)
    val points = RootExperienceQueryTargetsPointsCommand(this)
}

class RootExperienceQueryCommand(
    parent: CommandNode
): CommandLiteral(parent, "query") {
    fun targets(targets: Selector): RootExperienceQueryTargetsCommand {
        return RootExperienceQueryTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector): RootExperienceQueryTargetsCommand {
        return targets(targets)
    }
}

class RootExperienceSetTargetsAmountLevelsCommand(
    parent: CommandNode,
    literal: String? = "levels"
): CommandLiteral(parent, literal)

class RootExperienceSetTargetsAmountPointsCommand(
    parent: CommandNode,
    literal: String? = "points"
): CommandLiteral(parent, literal)

class RootExperienceSetTargetsAmountCommand(
    parent: CommandNode,
    amount: Int
): CommandArgument(parent, amount) {
    val levels = RootExperienceSetTargetsAmountLevelsCommand(this)
    val points = RootExperienceSetTargetsAmountPointsCommand(this)
}

class RootExperienceSetTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun amount(amount: Int): RootExperienceSetTargetsAmountCommand {
        return RootExperienceSetTargetsAmountCommand(this, amount)
    }
}

class RootExperienceSetCommand(
    parent: CommandNode
): CommandLiteral(parent, "set") {
    fun targets(targets: Selector): RootExperienceSetTargetsCommand {
        return RootExperienceSetTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, amount: Int): RootExperienceSetTargetsAmountCommand {
        return targets(targets).amount(amount)
    }
}

class RootExperienceCommand(
    parent: CommandNode?,
    literal: String? = "experience"
): CommandLiteral(parent, literal) {
    val add = RootExperienceAddCommand(this)
    val query = RootExperienceQueryCommand(this)
    val set = RootExperienceSetCommand(this)
}
val experience = RootExperienceCommand(null)