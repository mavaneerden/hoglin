package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootSetblockPosBlockDestroyCommand(
    parent: CommandNode,
    literal: String? = "destroy"
): CommandLiteral(parent, literal)

class RootSetblockPosBlockKeepCommand(
    parent: CommandNode,
    literal: String? = "keep"
): CommandLiteral(parent, literal)

class RootSetblockPosBlockReplaceCommand(
    parent: CommandNode,
    literal: String? = "replace"
): CommandLiteral(parent, literal)

class RootSetblockPosBlockCommand(
    parent: CommandNode,
    block: String
): CommandArgument(parent, block) {
    val destroy = RootSetblockPosBlockDestroyCommand(this)
    val keep = RootSetblockPosBlockKeepCommand(this)
    val replace = RootSetblockPosBlockReplaceCommand(this)
}

class RootSetblockPosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos) {
    fun block(block: String): RootSetblockPosBlockCommand {
        return RootSetblockPosBlockCommand(this, block)
    }
}

class RootSetblockCommand(
    parent: CommandNode?,
    literal: String? = "setblock"
): CommandLiteral(parent, literal) {
    fun pos(pos: String): RootSetblockPosCommand {
        return RootSetblockPosCommand(this, pos)
    }

    operator fun invoke(pos: String, block: String): RootSetblockPosBlockCommand {
        return pos(pos).block(block)
    }
}
val setblock = RootSetblockCommand(null)