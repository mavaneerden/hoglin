package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootAttributeTargetAttributeBaseGetScaleCommand(
    parent: CommandNode,
    scale: Double? = null
): CommandArgument(parent, scale)

class RootAttributeTargetAttributeBaseGetCommand(
    parent: CommandNode
): CommandLiteral(parent, "get") {
    fun scale(scale: Double? = null): RootAttributeTargetAttributeBaseGetScaleCommand {
        return RootAttributeTargetAttributeBaseGetScaleCommand(this, scale)
    }

    operator fun invoke(scale: Double? = null): RootAttributeTargetAttributeBaseGetScaleCommand {
        return scale(scale)
    }
}

class RootAttributeTargetAttributeBaseSetValueCommand(
    parent: CommandNode,
    value: Double
): CommandArgument(parent, value)

class RootAttributeTargetAttributeBaseSetCommand(
    parent: CommandNode
): CommandLiteral(parent, "set") {
    fun value(value: Double): RootAttributeTargetAttributeBaseSetValueCommand {
        return RootAttributeTargetAttributeBaseSetValueCommand(this, value)
    }

    operator fun invoke(value: Double): RootAttributeTargetAttributeBaseSetValueCommand {
        return value(value)
    }
}

class RootAttributeTargetAttributeBaseCommand(
    parent: CommandNode
): CommandLiteral(parent, "base") {
    val get = RootAttributeTargetAttributeBaseGetCommand(this)
    val set = RootAttributeTargetAttributeBaseSetCommand(this)
}

class RootAttributeTargetAttributeGetScaleCommand(
    parent: CommandNode,
    scale: Double? = null
): CommandArgument(parent, scale)

class RootAttributeTargetAttributeGetCommand(
    parent: CommandNode
): CommandLiteral(parent, "get") {
    fun scale(scale: Double? = null): RootAttributeTargetAttributeGetScaleCommand {
        return RootAttributeTargetAttributeGetScaleCommand(this, scale)
    }

    operator fun invoke(scale: Double? = null): RootAttributeTargetAttributeGetScaleCommand {
        return scale(scale)
    }
}

class RootAttributeTargetAttributeModifierAddUuidNameValueAddCommand(
    parent: CommandNode
): CommandLiteral(parent, "add")

class RootAttributeTargetAttributeModifierAddUuidNameValueMultiplyCommand(
    parent: CommandNode
): CommandLiteral(parent, "multiply")

class RootAttributeTargetAttributeModifierAddUuidNameValueMultiplyBaseCommand(
    parent: CommandNode
): CommandLiteral(parent, "multiply_base")

class RootAttributeTargetAttributeModifierAddUuidNameValueCommand(
    parent: CommandNode,
    value: Double
): CommandArgument(parent, value) {
    val add = RootAttributeTargetAttributeModifierAddUuidNameValueAddCommand(this)
    val multiply = RootAttributeTargetAttributeModifierAddUuidNameValueMultiplyCommand(this)
    val multiplyBase = RootAttributeTargetAttributeModifierAddUuidNameValueMultiplyBaseCommand(this)
}

class RootAttributeTargetAttributeModifierAddUuidNameCommand(
    parent: CommandNode,
    name: String
): CommandArgument(parent, name) {
    fun value(value: Double): RootAttributeTargetAttributeModifierAddUuidNameValueCommand {
        return RootAttributeTargetAttributeModifierAddUuidNameValueCommand(this, value)
    }
}

class RootAttributeTargetAttributeModifierAddUuidCommand(
    parent: CommandNode,
    uuid: String
): CommandArgument(parent, uuid) {
    fun name(name: String): RootAttributeTargetAttributeModifierAddUuidNameCommand {
        return RootAttributeTargetAttributeModifierAddUuidNameCommand(this, name)
    }
}

class RootAttributeTargetAttributeModifierAddCommand(
    parent: CommandNode
): CommandLiteral(parent, "add") {
    fun uuid(uuid: String): RootAttributeTargetAttributeModifierAddUuidCommand {
        return RootAttributeTargetAttributeModifierAddUuidCommand(this, uuid)
    }

    operator fun invoke(uuid: String, name: String, value: Double): RootAttributeTargetAttributeModifierAddUuidNameValueCommand {
        return uuid(uuid).name(name).value(value)
    }
}

class RootAttributeTargetAttributeModifierRemoveUuidCommand(
    parent: CommandNode,
    uuid: String
): CommandArgument(parent, uuid)

class RootAttributeTargetAttributeModifierRemoveCommand(
    parent: CommandNode
): CommandLiteral(parent, "remove") {
    fun uuid(uuid: String): RootAttributeTargetAttributeModifierRemoveUuidCommand {
        return RootAttributeTargetAttributeModifierRemoveUuidCommand(this, uuid)
    }

    operator fun invoke(uuid: String): RootAttributeTargetAttributeModifierRemoveUuidCommand {
        return uuid(uuid)
    }
}

class RootAttributeTargetAttributeModifierValueGetUuidScaleCommand(
    parent: CommandNode,
    scale: Double? = null
): CommandArgument(parent, scale)

class RootAttributeTargetAttributeModifierValueGetUuidCommand(
    parent: CommandNode,
    uuid: String
): CommandArgument(parent, uuid) {
    fun scale(scale: Double? = null): RootAttributeTargetAttributeModifierValueGetUuidScaleCommand {
        return RootAttributeTargetAttributeModifierValueGetUuidScaleCommand(this, scale)
    }
}

class RootAttributeTargetAttributeModifierValueGetCommand(
    parent: CommandNode
): CommandLiteral(parent, "get") {
    fun uuid(uuid: String): RootAttributeTargetAttributeModifierValueGetUuidCommand {
        return RootAttributeTargetAttributeModifierValueGetUuidCommand(this, uuid)
    }

    operator fun invoke(uuid: String, scale: Double? = null): RootAttributeTargetAttributeModifierValueGetUuidScaleCommand {
        return uuid(uuid).scale(scale)
    }
}

class RootAttributeTargetAttributeModifierValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value") {
    val get = RootAttributeTargetAttributeModifierValueGetCommand(this)
}

class RootAttributeTargetAttributeModifierCommand(
    parent: CommandNode
): CommandLiteral(parent, "modifier") {
    val add = RootAttributeTargetAttributeModifierAddCommand(this)
    val remove = RootAttributeTargetAttributeModifierRemoveCommand(this)
    val value = RootAttributeTargetAttributeModifierValueCommand(this)
}

class RootAttributeTargetAttributeCommand(
    parent: CommandNode,
    attribute: String
): CommandArgument(parent, attribute) {
    val base = RootAttributeTargetAttributeBaseCommand(this)
    val get = RootAttributeTargetAttributeGetCommand(this)
    val modifier = RootAttributeTargetAttributeModifierCommand(this)
}

class RootAttributeTargetCommand(
    parent: CommandNode,
    target: Selector
): CommandArgument(parent, target) {
    fun attribute(attribute: String): RootAttributeTargetAttributeCommand {
        return RootAttributeTargetAttributeCommand(this, attribute)
    }
}

class RootAttributeCommand(
    parent: CommandNode?,
    literal: String? = "attribute"
): CommandLiteral(parent, literal) {
    fun target(target: Selector): RootAttributeTargetCommand {
        return RootAttributeTargetCommand(this, target)
    }

    operator fun invoke(target: Selector, attribute: String): RootAttributeTargetAttributeCommand {
        return target(target).attribute(attribute)
    }
}
val attribute = RootAttributeCommand(null)