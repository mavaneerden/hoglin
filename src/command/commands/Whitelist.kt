package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootWhitelistAddTargetsCommand(
    parent: CommandNode,
    targets: String
): CommandArgument(parent, targets)

class RootWhitelistAddCommand(
    parent: CommandNode
): CommandLiteral(parent, "add") {
    fun targets(targets: String): RootWhitelistAddTargetsCommand {
        return RootWhitelistAddTargetsCommand(this, targets)
    }

    operator fun invoke(targets: String): RootWhitelistAddTargetsCommand {
        return targets(targets)
    }
}

class RootWhitelistListCommand(
    parent: CommandNode
): CommandLiteral(parent, "list")

class RootWhitelistOffCommand(
    parent: CommandNode
): CommandLiteral(parent, "off")

class RootWhitelistOnCommand(
    parent: CommandNode
): CommandLiteral(parent, "on")

class RootWhitelistReloadCommand(
    parent: CommandNode
): CommandLiteral(parent, "reload")

class RootWhitelistRemoveTargetsCommand(
    parent: CommandNode,
    targets: String
): CommandArgument(parent, targets)

class RootWhitelistRemoveCommand(
    parent: CommandNode
): CommandLiteral(parent, "remove") {
    fun targets(targets: String): RootWhitelistRemoveTargetsCommand {
        return RootWhitelistRemoveTargetsCommand(this, targets)
    }

    operator fun invoke(targets: String): RootWhitelistRemoveTargetsCommand {
        return targets(targets)
    }
}

class RootWhitelistCommand(
    parent: CommandNode?,
    literal: String? = "whitelist"
): CommandLiteral(parent, literal) {
    val add = RootWhitelistAddCommand(this)
    val list = RootWhitelistListCommand(this)
    val off = RootWhitelistOffCommand(this)
    val on = RootWhitelistOnCommand(this)
    val reload = RootWhitelistReloadCommand(this)
    val remove = RootWhitelistRemoveCommand(this)
}
val whitelist = RootWhitelistCommand(null)