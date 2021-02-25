package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootAdvancementGrantTargetsEverythingCommand(
    parent: CommandNode
): CommandLiteral(parent, "everything")

class RootAdvancementGrantTargetsFromAdvancementCommand(
    parent: CommandNode,
    advancement: String
): CommandArgument(parent, advancement)

class RootAdvancementGrantTargetsFromCommand(
    parent: CommandNode
): CommandLiteral(parent, "from") {
    fun advancement(advancement: String): RootAdvancementGrantTargetsFromAdvancementCommand {
        return RootAdvancementGrantTargetsFromAdvancementCommand(this, advancement)
    }

    operator fun invoke(advancement: String): RootAdvancementGrantTargetsFromAdvancementCommand {
        return advancement(advancement)
    }
}

class RootAdvancementGrantTargetsOnlyAdvancementCriterionCommand(
    parent: CommandNode,
    criterion: String? = null
): CommandArgument(parent, criterion)

class RootAdvancementGrantTargetsOnlyAdvancementCommand(
    parent: CommandNode,
    advancement: String
): CommandArgument(parent, advancement) {
    fun criterion(criterion: String? = null): RootAdvancementGrantTargetsOnlyAdvancementCriterionCommand {
        return RootAdvancementGrantTargetsOnlyAdvancementCriterionCommand(this, criterion)
    }
}

class RootAdvancementGrantTargetsOnlyCommand(
    parent: CommandNode
): CommandLiteral(parent, "only") {
    fun advancement(advancement: String): RootAdvancementGrantTargetsOnlyAdvancementCommand {
        return RootAdvancementGrantTargetsOnlyAdvancementCommand(this, advancement)
    }

    operator fun invoke(advancement: String, criterion: String? = null): RootAdvancementGrantTargetsOnlyAdvancementCriterionCommand {
        return advancement(advancement).criterion(criterion)
    }
}

class RootAdvancementGrantTargetsThroughAdvancementCommand(
    parent: CommandNode,
    advancement: String
): CommandArgument(parent, advancement)

class RootAdvancementGrantTargetsThroughCommand(
    parent: CommandNode
): CommandLiteral(parent, "through") {
    fun advancement(advancement: String): RootAdvancementGrantTargetsThroughAdvancementCommand {
        return RootAdvancementGrantTargetsThroughAdvancementCommand(this, advancement)
    }

    operator fun invoke(advancement: String): RootAdvancementGrantTargetsThroughAdvancementCommand {
        return advancement(advancement)
    }
}

class RootAdvancementGrantTargetsUntilAdvancementCommand(
    parent: CommandNode,
    advancement: String
): CommandArgument(parent, advancement)

class RootAdvancementGrantTargetsUntilCommand(
    parent: CommandNode
): CommandLiteral(parent, "until") {
    fun advancement(advancement: String): RootAdvancementGrantTargetsUntilAdvancementCommand {
        return RootAdvancementGrantTargetsUntilAdvancementCommand(this, advancement)
    }

    operator fun invoke(advancement: String): RootAdvancementGrantTargetsUntilAdvancementCommand {
        return advancement(advancement)
    }
}

class RootAdvancementGrantTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    val everything = RootAdvancementGrantTargetsEverythingCommand(this)
    val from = RootAdvancementGrantTargetsFromCommand(this)
    val only = RootAdvancementGrantTargetsOnlyCommand(this)
    val through = RootAdvancementGrantTargetsThroughCommand(this)
    val until = RootAdvancementGrantTargetsUntilCommand(this)
}

class RootAdvancementGrantCommand(
    parent: CommandNode
): CommandLiteral(parent, "grant") {
    fun targets(targets: Selector): RootAdvancementGrantTargetsCommand {
        return RootAdvancementGrantTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector): RootAdvancementGrantTargetsCommand {
        return targets(targets)
    }
}

class RootAdvancementRevokeTargetsEverythingCommand(
    parent: CommandNode
): CommandLiteral(parent, "everything")

class RootAdvancementRevokeTargetsFromAdvancementCommand(
    parent: CommandNode,
    advancement: String
): CommandArgument(parent, advancement)

class RootAdvancementRevokeTargetsFromCommand(
    parent: CommandNode
): CommandLiteral(parent, "from") {
    fun advancement(advancement: String): RootAdvancementRevokeTargetsFromAdvancementCommand {
        return RootAdvancementRevokeTargetsFromAdvancementCommand(this, advancement)
    }

    operator fun invoke(advancement: String): RootAdvancementRevokeTargetsFromAdvancementCommand {
        return advancement(advancement)
    }
}

class RootAdvancementRevokeTargetsOnlyAdvancementCriterionCommand(
    parent: CommandNode,
    criterion: String? = null
): CommandArgument(parent, criterion)

class RootAdvancementRevokeTargetsOnlyAdvancementCommand(
    parent: CommandNode,
    advancement: String
): CommandArgument(parent, advancement) {
    fun criterion(criterion: String? = null): RootAdvancementRevokeTargetsOnlyAdvancementCriterionCommand {
        return RootAdvancementRevokeTargetsOnlyAdvancementCriterionCommand(this, criterion)
    }
}

class RootAdvancementRevokeTargetsOnlyCommand(
    parent: CommandNode
): CommandLiteral(parent, "only") {
    fun advancement(advancement: String): RootAdvancementRevokeTargetsOnlyAdvancementCommand {
        return RootAdvancementRevokeTargetsOnlyAdvancementCommand(this, advancement)
    }

    operator fun invoke(advancement: String, criterion: String? = null): RootAdvancementRevokeTargetsOnlyAdvancementCriterionCommand {
        return advancement(advancement).criterion(criterion)
    }
}

class RootAdvancementRevokeTargetsThroughAdvancementCommand(
    parent: CommandNode,
    advancement: String
): CommandArgument(parent, advancement)

class RootAdvancementRevokeTargetsThroughCommand(
    parent: CommandNode
): CommandLiteral(parent, "through") {
    fun advancement(advancement: String): RootAdvancementRevokeTargetsThroughAdvancementCommand {
        return RootAdvancementRevokeTargetsThroughAdvancementCommand(this, advancement)
    }

    operator fun invoke(advancement: String): RootAdvancementRevokeTargetsThroughAdvancementCommand {
        return advancement(advancement)
    }
}

class RootAdvancementRevokeTargetsUntilAdvancementCommand(
    parent: CommandNode,
    advancement: String
): CommandArgument(parent, advancement)

class RootAdvancementRevokeTargetsUntilCommand(
    parent: CommandNode
): CommandLiteral(parent, "until") {
    fun advancement(advancement: String): RootAdvancementRevokeTargetsUntilAdvancementCommand {
        return RootAdvancementRevokeTargetsUntilAdvancementCommand(this, advancement)
    }

    operator fun invoke(advancement: String): RootAdvancementRevokeTargetsUntilAdvancementCommand {
        return advancement(advancement)
    }
}

class RootAdvancementRevokeTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    val everything = RootAdvancementRevokeTargetsEverythingCommand(this)
    val from = RootAdvancementRevokeTargetsFromCommand(this)
    val only = RootAdvancementRevokeTargetsOnlyCommand(this)
    val through = RootAdvancementRevokeTargetsThroughCommand(this)
    val until = RootAdvancementRevokeTargetsUntilCommand(this)
}

class RootAdvancementRevokeCommand(
    parent: CommandNode
): CommandLiteral(parent, "revoke") {
    fun targets(targets: Selector): RootAdvancementRevokeTargetsCommand {
        return RootAdvancementRevokeTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector): RootAdvancementRevokeTargetsCommand {
        return targets(targets)
    }
}

class RootAdvancementCommand(
    parent: CommandNode?,
    literal: String? = "advancement"
): CommandLiteral(parent, literal) {
    val grant = RootAdvancementGrantCommand(this)
    val revoke = RootAdvancementRevokeCommand(this)
}
val advancement = RootAdvancementCommand(null)