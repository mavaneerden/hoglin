package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootFillFromToBlockDestroyCommand(
    parent: CommandNode,
    literal: String? = "destroy"
): CommandLiteral(parent, literal)

class RootFillFromToBlockHollowCommand(
    parent: CommandNode,
    literal: String? = "hollow"
): CommandLiteral(parent, literal)

class RootFillFromToBlockKeepCommand(
    parent: CommandNode,
    literal: String? = "keep"
): CommandLiteral(parent, literal)

class RootFillFromToBlockOutlineCommand(
    parent: CommandNode,
    literal: String? = "outline"
): CommandLiteral(parent, literal)

class RootFillFromToBlockReplaceFilterCommand(
    parent: CommandNode,
    filter: String? = null
): CommandArgument(parent, filter)

class RootFillFromToBlockReplaceCommand(
    parent: CommandNode,
    literal: String? = "replace"
): CommandLiteral(parent, literal) {
    fun filter(filter: String? = null): RootFillFromToBlockReplaceFilterCommand {
        return RootFillFromToBlockReplaceFilterCommand(this, filter)
    }

    operator fun invoke(filter: String? = null): RootFillFromToBlockReplaceFilterCommand {
        return filter(filter)
    }
}

class RootFillFromToBlockCommand(
    parent: CommandNode,
    block: String
): CommandArgument(parent, block) {
    val destroy = RootFillFromToBlockDestroyCommand(this)
    val hollow = RootFillFromToBlockHollowCommand(this)
    val keep = RootFillFromToBlockKeepCommand(this)
    val outline = RootFillFromToBlockOutlineCommand(this)
    val replace = RootFillFromToBlockReplaceCommand(this)
}

class RootFillFromToCommand(
    parent: CommandNode,
    to: String
): CommandArgument(parent, to) {
    fun block(block: String): RootFillFromToBlockCommand {
        return RootFillFromToBlockCommand(this, block)
    }
}

class RootFillFromCommand(
    parent: CommandNode,
    from: String
): CommandArgument(parent, from) {
    fun to(to: String): RootFillFromToCommand {
        return RootFillFromToCommand(this, to)
    }
}

class RootFillCommand(
    parent: CommandNode?,
    literal: String? = "fill"
): CommandLiteral(parent, literal) {
    fun from(from: String): RootFillFromCommand {
        return RootFillFromCommand(this, from)
    }

    operator fun invoke(from: String, to: String, block: String): RootFillFromToBlockCommand {
        return from(from).to(to).block(block)
    }
}
val fill = RootFillCommand(null)