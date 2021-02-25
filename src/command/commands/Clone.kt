package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootCloneBeginEndDestinationFilteredFilterForceCommand(
    parent: CommandNode,
    literal: String? = "force"
): CommandLiteral(parent, literal)

class RootCloneBeginEndDestinationFilteredFilterMoveCommand(
    parent: CommandNode,
    literal: String? = "move"
): CommandLiteral(parent, literal)

class RootCloneBeginEndDestinationFilteredFilterNormalCommand(
    parent: CommandNode,
    literal: String? = "normal"
): CommandLiteral(parent, literal)

class RootCloneBeginEndDestinationFilteredFilterCommand(
    parent: CommandNode,
    filter: String? = null
): CommandArgument(parent, filter) {
    val force = RootCloneBeginEndDestinationFilteredFilterForceCommand(this)
    val move = RootCloneBeginEndDestinationFilteredFilterMoveCommand(this)
    val normal = RootCloneBeginEndDestinationFilteredFilterNormalCommand(this)
}

class RootCloneBeginEndDestinationFilteredCommand(
    parent: CommandNode,
    literal: String? = "filtered"
): CommandLiteral(parent, literal) {
    fun filter(filter: String? = null): RootCloneBeginEndDestinationFilteredFilterCommand {
        return RootCloneBeginEndDestinationFilteredFilterCommand(this, filter)
    }

    operator fun invoke(filter: String? = null): RootCloneBeginEndDestinationFilteredFilterCommand {
        return filter(filter)
    }
}

class RootCloneBeginEndDestinationMaskedForceCommand(
    parent: CommandNode,
    literal: String? = "force"
): CommandLiteral(parent, literal)

class RootCloneBeginEndDestinationMaskedMoveCommand(
    parent: CommandNode,
    literal: String? = "move"
): CommandLiteral(parent, literal)

class RootCloneBeginEndDestinationMaskedNormalCommand(
    parent: CommandNode,
    literal: String? = "normal"
): CommandLiteral(parent, literal)

class RootCloneBeginEndDestinationMaskedCommand(
    parent: CommandNode,
    literal: String? = "masked"
): CommandLiteral(parent, literal) {
    val force = RootCloneBeginEndDestinationMaskedForceCommand(this)
    val move = RootCloneBeginEndDestinationMaskedMoveCommand(this)
    val normal = RootCloneBeginEndDestinationMaskedNormalCommand(this)
}

class RootCloneBeginEndDestinationReplaceForceCommand(
    parent: CommandNode,
    literal: String? = "force"
): CommandLiteral(parent, literal)

class RootCloneBeginEndDestinationReplaceMoveCommand(
    parent: CommandNode,
    literal: String? = "move"
): CommandLiteral(parent, literal)

class RootCloneBeginEndDestinationReplaceNormalCommand(
    parent: CommandNode,
    literal: String? = "normal"
): CommandLiteral(parent, literal)

class RootCloneBeginEndDestinationReplaceCommand(
    parent: CommandNode,
    literal: String? = "replace"
): CommandLiteral(parent, literal) {
    val force = RootCloneBeginEndDestinationReplaceForceCommand(this)
    val move = RootCloneBeginEndDestinationReplaceMoveCommand(this)
    val normal = RootCloneBeginEndDestinationReplaceNormalCommand(this)
}

class RootCloneBeginEndDestinationCommand(
    parent: CommandNode,
    destination: String
): CommandArgument(parent, destination) {
    val filtered = RootCloneBeginEndDestinationFilteredCommand(this)
    val masked = RootCloneBeginEndDestinationMaskedCommand(this)
    val replace = RootCloneBeginEndDestinationReplaceCommand(this)
}

class RootCloneBeginEndCommand(
    parent: CommandNode,
    end: String
): CommandArgument(parent, end) {
    fun destination(destination: String): RootCloneBeginEndDestinationCommand {
        return RootCloneBeginEndDestinationCommand(this, destination)
    }
}

class RootCloneBeginCommand(
    parent: CommandNode,
    begin: String
): CommandArgument(parent, begin) {
    fun end(end: String): RootCloneBeginEndCommand {
        return RootCloneBeginEndCommand(this, end)
    }
}

class RootCloneCommand(
    parent: CommandNode?,
    literal: String? = "clone"
): CommandLiteral(parent, literal) {
    fun begin(begin: String): RootCloneBeginCommand {
        return RootCloneBeginCommand(this, begin)
    }

    operator fun invoke(begin: String, end: String, destination: String): RootCloneBeginEndDestinationCommand {
        return begin(begin).end(end).destination(destination)
    }
}
val clone = RootCloneCommand(null)