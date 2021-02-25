package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootSummonEntityPosNbtCommand(
    parent: CommandNode,
    nbt: String? = null
): CommandArgument(parent, nbt)

class RootSummonEntityPosCommand(
    parent: CommandNode,
    pos: Coordinates? = null
): CommandArgument(parent, pos) {
    fun nbt(nbt: String? = null): RootSummonEntityPosNbtCommand {
        return RootSummonEntityPosNbtCommand(this, nbt)
    }
}

class RootSummonEntityCommand(
    parent: CommandNode,
    entity: String
): CommandArgument(parent, entity) {
    fun pos(pos: Coordinates? = null): RootSummonEntityPosCommand {
        return RootSummonEntityPosCommand(this, pos)
    }
}

class RootSummonCommand(
    parent: CommandNode?,
    literal: String? = "summon"
): CommandLiteral(parent, literal) {
    fun entity(entity: String): RootSummonEntityCommand {
        return RootSummonEntityCommand(this, entity)
    }

    operator fun invoke(entity: String, pos: Coordinates? = null, nbt: String? = null): RootSummonEntityPosNbtCommand {
        return entity(entity).pos(pos).nbt(nbt)
    }
}
val summon = RootSummonCommand(null)