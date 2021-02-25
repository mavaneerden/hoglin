package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootDatapackDisableNameCommand(
    parent: CommandNode,
    name: String
): CommandArgument(parent, name)

class RootDatapackDisableCommand(
    parent: CommandNode
): CommandLiteral(parent, "disable") {
    fun name(name: String): RootDatapackDisableNameCommand {
        return RootDatapackDisableNameCommand(this, name)
    }

    operator fun invoke(name: String): RootDatapackDisableNameCommand {
        return name(name)
    }
}

class RootDatapackEnableNameAfterExistingCommand(
    parent: CommandNode,
    existing: String? = null
): CommandArgument(parent, existing)

class RootDatapackEnableNameAfterCommand(
    parent: CommandNode,
    literal: String? = "after"
): CommandLiteral(parent, literal) {
    fun existing(existing: String? = null): RootDatapackEnableNameAfterExistingCommand {
        return RootDatapackEnableNameAfterExistingCommand(this, existing)
    }

    operator fun invoke(existing: String? = null): RootDatapackEnableNameAfterExistingCommand {
        return existing(existing)
    }
}

class RootDatapackEnableNameBeforeExistingCommand(
    parent: CommandNode,
    existing: String? = null
): CommandArgument(parent, existing)

class RootDatapackEnableNameBeforeCommand(
    parent: CommandNode,
    literal: String? = "before"
): CommandLiteral(parent, literal) {
    fun existing(existing: String? = null): RootDatapackEnableNameBeforeExistingCommand {
        return RootDatapackEnableNameBeforeExistingCommand(this, existing)
    }

    operator fun invoke(existing: String? = null): RootDatapackEnableNameBeforeExistingCommand {
        return existing(existing)
    }
}

class RootDatapackEnableNameFirstCommand(
    parent: CommandNode,
    literal: String? = "first"
): CommandLiteral(parent, literal)

class RootDatapackEnableNameLastCommand(
    parent: CommandNode,
    literal: String? = "last"
): CommandLiteral(parent, literal)

class RootDatapackEnableNameCommand(
    parent: CommandNode,
    name: String
): CommandArgument(parent, name) {
    val after = RootDatapackEnableNameAfterCommand(this)
    val before = RootDatapackEnableNameBeforeCommand(this)
    val first = RootDatapackEnableNameFirstCommand(this)
    val last = RootDatapackEnableNameLastCommand(this)
}

class RootDatapackEnableCommand(
    parent: CommandNode
): CommandLiteral(parent, "enable") {
    fun name(name: String): RootDatapackEnableNameCommand {
        return RootDatapackEnableNameCommand(this, name)
    }

    operator fun invoke(name: String): RootDatapackEnableNameCommand {
        return name(name)
    }
}

class RootDatapackListAvailableCommand(
    parent: CommandNode,
    literal: String? = "available"
): CommandLiteral(parent, literal)

class RootDatapackListEnabledCommand(
    parent: CommandNode,
    literal: String? = "enabled"
): CommandLiteral(parent, literal)

class RootDatapackListCommand(
    parent: CommandNode
): CommandLiteral(parent, "list") {
    val available = RootDatapackListAvailableCommand(this)
    val enabled = RootDatapackListEnabledCommand(this)
}

class RootDatapackCommand(
    parent: CommandNode?,
    literal: String? = "datapack"
): CommandLiteral(parent, literal) {
    val disable = RootDatapackDisableCommand(this)
    val enable = RootDatapackEnableCommand(this)
    val list = RootDatapackListCommand(this)
}
val datapack = RootDatapackCommand(null)