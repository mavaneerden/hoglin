package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootTagTargetsAddNameCommand(
    parent: CommandNode,
    name: String
): CommandArgument(parent, name)

class RootTagTargetsAddCommand(
    parent: CommandNode
): CommandLiteral(parent, "add") {
    fun name(name: String): RootTagTargetsAddNameCommand {
        return RootTagTargetsAddNameCommand(this, name)
    }

    operator fun invoke(name: String): RootTagTargetsAddNameCommand {
        return name(name)
    }
}

class RootTagTargetsListCommand(
    parent: CommandNode
): CommandLiteral(parent, "list")

class RootTagTargetsRemoveNameCommand(
    parent: CommandNode,
    name: String
): CommandArgument(parent, name)

class RootTagTargetsRemoveCommand(
    parent: CommandNode
): CommandLiteral(parent, "remove") {
    fun name(name: String): RootTagTargetsRemoveNameCommand {
        return RootTagTargetsRemoveNameCommand(this, name)
    }

    operator fun invoke(name: String): RootTagTargetsRemoveNameCommand {
        return name(name)
    }
}

class RootTagTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    val add = RootTagTargetsAddCommand(this)
    val list = RootTagTargetsListCommand(this)
    val remove = RootTagTargetsRemoveCommand(this)
}

class RootTagCommand(
    parent: CommandNode?,
    literal: String? = "tag"
): CommandLiteral(parent, literal) {
    fun targets(targets: Selector): RootTagTargetsCommand {
        return RootTagTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector): RootTagTargetsCommand {
        return targets(targets)
    }
}
val tag = RootTagCommand(null)