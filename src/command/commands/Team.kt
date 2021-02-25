package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootTeamAddTeamDisplayNameCommand(
    parent: CommandNode,
    displayName: String? = null
): CommandArgument(parent, displayName)

class RootTeamAddTeamCommand(
    parent: CommandNode,
    team: String
): CommandArgument(parent, team) {
    fun displayName(displayName: String? = null): RootTeamAddTeamDisplayNameCommand {
        return RootTeamAddTeamDisplayNameCommand(this, displayName)
    }
}

class RootTeamAddCommand(
    parent: CommandNode
): CommandLiteral(parent, "add") {
    fun team(team: String): RootTeamAddTeamCommand {
        return RootTeamAddTeamCommand(this, team)
    }

    operator fun invoke(team: String, displayName: String? = null): RootTeamAddTeamDisplayNameCommand {
        return team(team).displayName(displayName)
    }
}

class RootTeamEmptyTeamCommand(
    parent: CommandNode,
    team: String
): CommandArgument(parent, team)

class RootTeamEmptyCommand(
    parent: CommandNode
): CommandLiteral(parent, "empty") {
    fun team(team: String): RootTeamEmptyTeamCommand {
        return RootTeamEmptyTeamCommand(this, team)
    }

    operator fun invoke(team: String): RootTeamEmptyTeamCommand {
        return team(team)
    }
}

class RootTeamJoinTeamMembersCommand(
    parent: CommandNode,
    members: String? = null
): CommandArgument(parent, members)

class RootTeamJoinTeamCommand(
    parent: CommandNode,
    team: String
): CommandArgument(parent, team) {
    fun members(members: String? = null): RootTeamJoinTeamMembersCommand {
        return RootTeamJoinTeamMembersCommand(this, members)
    }
}

class RootTeamJoinCommand(
    parent: CommandNode
): CommandLiteral(parent, "join") {
    fun team(team: String): RootTeamJoinTeamCommand {
        return RootTeamJoinTeamCommand(this, team)
    }

    operator fun invoke(team: String, members: String? = null): RootTeamJoinTeamMembersCommand {
        return team(team).members(members)
    }
}

class RootTeamLeaveMembersCommand(
    parent: CommandNode,
    members: String
): CommandArgument(parent, members)

class RootTeamLeaveCommand(
    parent: CommandNode
): CommandLiteral(parent, "leave") {
    fun members(members: String): RootTeamLeaveMembersCommand {
        return RootTeamLeaveMembersCommand(this, members)
    }

    operator fun invoke(members: String): RootTeamLeaveMembersCommand {
        return members(members)
    }
}

class RootTeamListTeamCommand(
    parent: CommandNode,
    team: String? = null
): CommandArgument(parent, team)

class RootTeamListCommand(
    parent: CommandNode
): CommandLiteral(parent, "list") {
    fun team(team: String? = null): RootTeamListTeamCommand {
        return RootTeamListTeamCommand(this, team)
    }

    operator fun invoke(team: String? = null): RootTeamListTeamCommand {
        return team(team)
    }
}

class RootTeamModifyTeamCollisionRuleAlwaysCommand(
    parent: CommandNode
): CommandLiteral(parent, "always")

class RootTeamModifyTeamCollisionRuleNeverCommand(
    parent: CommandNode
): CommandLiteral(parent, "never")

class RootTeamModifyTeamCollisionRulePushOtherTeamsCommand(
    parent: CommandNode
): CommandLiteral(parent, "pushOtherTeams")

class RootTeamModifyTeamCollisionRulePushOwnTeamCommand(
    parent: CommandNode
): CommandLiteral(parent, "pushOwnTeam")

class RootTeamModifyTeamCollisionRuleCommand(
    parent: CommandNode
): CommandLiteral(parent, "collisionRule") {
    val always = RootTeamModifyTeamCollisionRuleAlwaysCommand(this)
    val never = RootTeamModifyTeamCollisionRuleNeverCommand(this)
    val pushOtherTeams = RootTeamModifyTeamCollisionRulePushOtherTeamsCommand(this)
    val pushOwnTeam = RootTeamModifyTeamCollisionRulePushOwnTeamCommand(this)
}

class RootTeamModifyTeamColorValueCommand(
    parent: CommandNode,
    value: String
): CommandArgument(parent, value)

class RootTeamModifyTeamColorCommand(
    parent: CommandNode
): CommandLiteral(parent, "color") {
    fun value(value: String): RootTeamModifyTeamColorValueCommand {
        return RootTeamModifyTeamColorValueCommand(this, value)
    }

    operator fun invoke(value: String): RootTeamModifyTeamColorValueCommand {
        return value(value)
    }
}

class RootTeamModifyTeamDeathMessageVisibilityAlwaysCommand(
    parent: CommandNode
): CommandLiteral(parent, "always")

class RootTeamModifyTeamDeathMessageVisibilityHideForOtherTeamsCommand(
    parent: CommandNode
): CommandLiteral(parent, "hideForOtherTeams")

class RootTeamModifyTeamDeathMessageVisibilityHideForOwnTeamCommand(
    parent: CommandNode
): CommandLiteral(parent, "hideForOwnTeam")

class RootTeamModifyTeamDeathMessageVisibilityNeverCommand(
    parent: CommandNode
): CommandLiteral(parent, "never")

class RootTeamModifyTeamDeathMessageVisibilityCommand(
    parent: CommandNode
): CommandLiteral(parent, "deathMessageVisibility") {
    val always = RootTeamModifyTeamDeathMessageVisibilityAlwaysCommand(this)
    val hideForOtherTeams = RootTeamModifyTeamDeathMessageVisibilityHideForOtherTeamsCommand(this)
    val hideForOwnTeam = RootTeamModifyTeamDeathMessageVisibilityHideForOwnTeamCommand(this)
    val never = RootTeamModifyTeamDeathMessageVisibilityNeverCommand(this)
}

class RootTeamModifyTeamDisplayNameDisplayNameCommand(
    parent: CommandNode,
    displayName: String
): CommandArgument(parent, displayName)

class RootTeamModifyTeamDisplayNameCommand(
    parent: CommandNode
): CommandLiteral(parent, "displayName") {
    fun displayName(displayName: String): RootTeamModifyTeamDisplayNameDisplayNameCommand {
        return RootTeamModifyTeamDisplayNameDisplayNameCommand(this, displayName)
    }

    operator fun invoke(displayName: String): RootTeamModifyTeamDisplayNameDisplayNameCommand {
        return displayName(displayName)
    }
}

class RootTeamModifyTeamFriendlyFireAllowedCommand(
    parent: CommandNode,
    allowed: Boolean
): CommandArgument(parent, allowed)

class RootTeamModifyTeamFriendlyFireCommand(
    parent: CommandNode
): CommandLiteral(parent, "friendlyFire") {
    fun allowed(allowed: Boolean): RootTeamModifyTeamFriendlyFireAllowedCommand {
        return RootTeamModifyTeamFriendlyFireAllowedCommand(this, allowed)
    }

    operator fun invoke(allowed: Boolean): RootTeamModifyTeamFriendlyFireAllowedCommand {
        return allowed(allowed)
    }
}

class RootTeamModifyTeamNametagVisibilityAlwaysCommand(
    parent: CommandNode
): CommandLiteral(parent, "always")

class RootTeamModifyTeamNametagVisibilityHideForOtherTeamsCommand(
    parent: CommandNode
): CommandLiteral(parent, "hideForOtherTeams")

class RootTeamModifyTeamNametagVisibilityHideForOwnTeamCommand(
    parent: CommandNode
): CommandLiteral(parent, "hideForOwnTeam")

class RootTeamModifyTeamNametagVisibilityNeverCommand(
    parent: CommandNode
): CommandLiteral(parent, "never")

class RootTeamModifyTeamNametagVisibilityCommand(
    parent: CommandNode
): CommandLiteral(parent, "nametagVisibility") {
    val always = RootTeamModifyTeamNametagVisibilityAlwaysCommand(this)
    val hideForOtherTeams = RootTeamModifyTeamNametagVisibilityHideForOtherTeamsCommand(this)
    val hideForOwnTeam = RootTeamModifyTeamNametagVisibilityHideForOwnTeamCommand(this)
    val never = RootTeamModifyTeamNametagVisibilityNeverCommand(this)
}

class RootTeamModifyTeamPrefixPrefixCommand(
    parent: CommandNode,
    prefix: String
): CommandArgument(parent, prefix)

class RootTeamModifyTeamPrefixCommand(
    parent: CommandNode
): CommandLiteral(parent, "prefix") {
    fun prefix(prefix: String): RootTeamModifyTeamPrefixPrefixCommand {
        return RootTeamModifyTeamPrefixPrefixCommand(this, prefix)
    }

    operator fun invoke(prefix: String): RootTeamModifyTeamPrefixPrefixCommand {
        return prefix(prefix)
    }
}

class RootTeamModifyTeamSeeFriendlyInvisiblesAllowedCommand(
    parent: CommandNode,
    allowed: Boolean
): CommandArgument(parent, allowed)

class RootTeamModifyTeamSeeFriendlyInvisiblesCommand(
    parent: CommandNode
): CommandLiteral(parent, "seeFriendlyInvisibles") {
    fun allowed(allowed: Boolean): RootTeamModifyTeamSeeFriendlyInvisiblesAllowedCommand {
        return RootTeamModifyTeamSeeFriendlyInvisiblesAllowedCommand(this, allowed)
    }

    operator fun invoke(allowed: Boolean): RootTeamModifyTeamSeeFriendlyInvisiblesAllowedCommand {
        return allowed(allowed)
    }
}

class RootTeamModifyTeamSuffixSuffixCommand(
    parent: CommandNode,
    suffix: String
): CommandArgument(parent, suffix)

class RootTeamModifyTeamSuffixCommand(
    parent: CommandNode
): CommandLiteral(parent, "suffix") {
    fun suffix(suffix: String): RootTeamModifyTeamSuffixSuffixCommand {
        return RootTeamModifyTeamSuffixSuffixCommand(this, suffix)
    }

    operator fun invoke(suffix: String): RootTeamModifyTeamSuffixSuffixCommand {
        return suffix(suffix)
    }
}

class RootTeamModifyTeamCommand(
    parent: CommandNode,
    team: String
): CommandArgument(parent, team) {
    val collisionRule = RootTeamModifyTeamCollisionRuleCommand(this)
    val color = RootTeamModifyTeamColorCommand(this)
    val deathMessageVisibility = RootTeamModifyTeamDeathMessageVisibilityCommand(this)
    val displayName = RootTeamModifyTeamDisplayNameCommand(this)
    val friendlyFire = RootTeamModifyTeamFriendlyFireCommand(this)
    val nametagVisibility = RootTeamModifyTeamNametagVisibilityCommand(this)
    val prefix = RootTeamModifyTeamPrefixCommand(this)
    val seeFriendlyInvisibles = RootTeamModifyTeamSeeFriendlyInvisiblesCommand(this)
    val suffix = RootTeamModifyTeamSuffixCommand(this)
}

class RootTeamModifyCommand(
    parent: CommandNode
): CommandLiteral(parent, "modify") {
    fun team(team: String): RootTeamModifyTeamCommand {
        return RootTeamModifyTeamCommand(this, team)
    }

    operator fun invoke(team: String): RootTeamModifyTeamCommand {
        return team(team)
    }
}

class RootTeamRemoveTeamCommand(
    parent: CommandNode,
    team: String
): CommandArgument(parent, team)

class RootTeamRemoveCommand(
    parent: CommandNode
): CommandLiteral(parent, "remove") {
    fun team(team: String): RootTeamRemoveTeamCommand {
        return RootTeamRemoveTeamCommand(this, team)
    }

    operator fun invoke(team: String): RootTeamRemoveTeamCommand {
        return team(team)
    }
}

class RootTeamCommand(
    parent: CommandNode?,
    literal: String? = "team"
): CommandLiteral(parent, literal) {
    val add = RootTeamAddCommand(this)
    val empty = RootTeamEmptyCommand(this)
    val join = RootTeamJoinCommand(this)
    val leave = RootTeamLeaveCommand(this)
    val list = RootTeamListCommand(this)
    val modify = RootTeamModifyCommand(this)
    val remove = RootTeamRemoveCommand(this)
}
val team = RootTeamCommand(null)