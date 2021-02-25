package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootSetworldspawnPosAngleCommand(
    parent: CommandNode,
    angle: Float? = null
): CommandArgument(parent, angle)

class RootSetworldspawnPosCommand(
    parent: CommandNode,
    pos: String? = null
): CommandArgument(parent, pos) {
    fun angle(angle: Float? = null): RootSetworldspawnPosAngleCommand {
        return RootSetworldspawnPosAngleCommand(this, angle)
    }
}

class RootSetworldspawnCommand(
    parent: CommandNode?,
    literal: String? = "setworldspawn"
): CommandLiteral(parent, literal) {
    fun pos(pos: String? = null): RootSetworldspawnPosCommand {
        return RootSetworldspawnPosCommand(this, pos)
    }

    operator fun invoke(pos: String? = null, angle: Float? = null): RootSetworldspawnPosAngleCommand {
        return pos(pos).angle(angle)
    }
}
val setworldspawn = RootSetworldspawnCommand(null)