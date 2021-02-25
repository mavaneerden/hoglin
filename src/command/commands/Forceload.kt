package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootForceloadAddFromToCommand(
    parent: CommandNode,
    to: String? = null
): CommandArgument(parent, to)

class RootForceloadAddFromCommand(
    parent: CommandNode,
    from: String
): CommandArgument(parent, from) {
    fun to(to: String? = null): RootForceloadAddFromToCommand {
        return RootForceloadAddFromToCommand(this, to)
    }
}

class RootForceloadAddCommand(
    parent: CommandNode
): CommandLiteral(parent, "add") {
    fun from(from: String): RootForceloadAddFromCommand {
        return RootForceloadAddFromCommand(this, from)
    }

    operator fun invoke(from: String, to: String? = null): RootForceloadAddFromToCommand {
        return from(from).to(to)
    }
}

class RootForceloadQueryPosCommand(
    parent: CommandNode,
    pos: String? = null
): CommandArgument(parent, pos)

class RootForceloadQueryCommand(
    parent: CommandNode
): CommandLiteral(parent, "query") {
    fun pos(pos: String? = null): RootForceloadQueryPosCommand {
        return RootForceloadQueryPosCommand(this, pos)
    }

    operator fun invoke(pos: String? = null): RootForceloadQueryPosCommand {
        return pos(pos)
    }
}

class RootForceloadRemoveAllCommand(
    parent: CommandNode
): CommandLiteral(parent, "all")

class RootForceloadRemoveFromToCommand(
    parent: CommandNode,
    to: String? = null
): CommandArgument(parent, to)

class RootForceloadRemoveFromCommand(
    parent: CommandNode,
    from: String
): CommandArgument(parent, from) {
    fun to(to: String? = null): RootForceloadRemoveFromToCommand {
        return RootForceloadRemoveFromToCommand(this, to)
    }
}

class RootForceloadRemoveCommand(
    parent: CommandNode
): CommandLiteral(parent, "remove") {
    val all = RootForceloadRemoveAllCommand(this)

        fun from(from: String): RootForceloadRemoveFromCommand {
        return RootForceloadRemoveFromCommand(this, from)
    }

    operator fun invoke(from: String, to: String? = null): RootForceloadRemoveFromToCommand {
        return from(from).to(to)
    }
}

class RootForceloadCommand(
    parent: CommandNode?,
    literal: String? = "forceload"
): CommandLiteral(parent, literal) {
    val add = RootForceloadAddCommand(this)
    val query = RootForceloadQueryCommand(this)
    val remove = RootForceloadRemoveCommand(this)
}
val forceload = RootForceloadCommand(null)