package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootWorldborderAddDistanceTimeCommand(
    parent: CommandNode,
    time: Int? = null
): CommandArgument(parent, time)

class RootWorldborderAddDistanceCommand(
    parent: CommandNode,
    distance: Float
): CommandArgument(parent, distance) {
    fun time(time: Int? = null): RootWorldborderAddDistanceTimeCommand {
        return RootWorldborderAddDistanceTimeCommand(this, time)
    }
}

class RootWorldborderAddCommand(
    parent: CommandNode
): CommandLiteral(parent, "add") {
    fun distance(distance: Float): RootWorldborderAddDistanceCommand {
        return RootWorldborderAddDistanceCommand(this, distance)
    }

    operator fun invoke(distance: Float, time: Int? = null): RootWorldborderAddDistanceTimeCommand {
        return distance(distance).time(time)
    }
}

class RootWorldborderCenterPosCommand(
    parent: CommandNode,
    pos: String
): CommandArgument(parent, pos)

class RootWorldborderCenterCommand(
    parent: CommandNode
): CommandLiteral(parent, "center") {
    fun pos(pos: String): RootWorldborderCenterPosCommand {
        return RootWorldborderCenterPosCommand(this, pos)
    }

    operator fun invoke(pos: String): RootWorldborderCenterPosCommand {
        return pos(pos)
    }
}

class RootWorldborderDamageAmountDamagePerBlockCommand(
    parent: CommandNode,
    damagePerBlock: Float
): CommandArgument(parent, damagePerBlock)

class RootWorldborderDamageAmountCommand(
    parent: CommandNode
): CommandLiteral(parent, "amount") {
    fun damagePerBlock(damagePerBlock: Float): RootWorldborderDamageAmountDamagePerBlockCommand {
        return RootWorldborderDamageAmountDamagePerBlockCommand(this, damagePerBlock)
    }

    operator fun invoke(damagePerBlock: Float): RootWorldborderDamageAmountDamagePerBlockCommand {
        return damagePerBlock(damagePerBlock)
    }
}

class RootWorldborderDamageBufferDistanceCommand(
    parent: CommandNode,
    distance: Float
): CommandArgument(parent, distance)

class RootWorldborderDamageBufferCommand(
    parent: CommandNode
): CommandLiteral(parent, "buffer") {
    fun distance(distance: Float): RootWorldborderDamageBufferDistanceCommand {
        return RootWorldborderDamageBufferDistanceCommand(this, distance)
    }

    operator fun invoke(distance: Float): RootWorldborderDamageBufferDistanceCommand {
        return distance(distance)
    }
}

class RootWorldborderDamageCommand(
    parent: CommandNode
): CommandLiteral(parent, "damage") {
    val amount = RootWorldborderDamageAmountCommand(this)
    val buffer = RootWorldborderDamageBufferCommand(this)
}

class RootWorldborderGetCommand(
    parent: CommandNode
): CommandLiteral(parent, "get")

class RootWorldborderSetDistanceTimeCommand(
    parent: CommandNode,
    time: Int? = null
): CommandArgument(parent, time)

class RootWorldborderSetDistanceCommand(
    parent: CommandNode,
    distance: Float
): CommandArgument(parent, distance) {
    fun time(time: Int? = null): RootWorldborderSetDistanceTimeCommand {
        return RootWorldborderSetDistanceTimeCommand(this, time)
    }
}

class RootWorldborderSetCommand(
    parent: CommandNode
): CommandLiteral(parent, "set") {
    fun distance(distance: Float): RootWorldborderSetDistanceCommand {
        return RootWorldborderSetDistanceCommand(this, distance)
    }

    operator fun invoke(distance: Float, time: Int? = null): RootWorldborderSetDistanceTimeCommand {
        return distance(distance).time(time)
    }
}

class RootWorldborderWarningDistanceDistanceCommand(
    parent: CommandNode,
    distance: Int
): CommandArgument(parent, distance)

class RootWorldborderWarningDistanceCommand(
    parent: CommandNode
): CommandLiteral(parent, "distance") {
    fun distance(distance: Int): RootWorldborderWarningDistanceDistanceCommand {
        return RootWorldborderWarningDistanceDistanceCommand(this, distance)
    }

    operator fun invoke(distance: Int): RootWorldborderWarningDistanceDistanceCommand {
        return distance(distance)
    }
}

class RootWorldborderWarningTimeTimeCommand(
    parent: CommandNode,
    time: Int
): CommandArgument(parent, time)

class RootWorldborderWarningTimeCommand(
    parent: CommandNode
): CommandLiteral(parent, "time") {
    fun time(time: Int): RootWorldborderWarningTimeTimeCommand {
        return RootWorldborderWarningTimeTimeCommand(this, time)
    }

    operator fun invoke(time: Int): RootWorldborderWarningTimeTimeCommand {
        return time(time)
    }
}

class RootWorldborderWarningCommand(
    parent: CommandNode
): CommandLiteral(parent, "warning") {
    val distance = RootWorldborderWarningDistanceCommand(this)
    val time = RootWorldborderWarningTimeCommand(this)
}

class RootWorldborderCommand(
    parent: CommandNode?,
    literal: String? = "worldborder"
): CommandLiteral(parent, literal) {
    val add = RootWorldborderAddCommand(this)
    val center = RootWorldborderCenterCommand(this)
    val damage = RootWorldborderDamageCommand(this)
    val get = RootWorldborderGetCommand(this)
    val set = RootWorldborderSetCommand(this)
    val warning = RootWorldborderWarningCommand(this)
}
val worldborder = RootWorldborderCommand(null)