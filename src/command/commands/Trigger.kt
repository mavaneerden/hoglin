package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootTriggerObjectiveAddValueCommand(
    parent: CommandNode,
    value: Int? = null
): CommandArgument(parent, value)

class RootTriggerObjectiveAddCommand(
    parent: CommandNode,
    literal: String? = "add"
): CommandLiteral(parent, literal) {
    fun value(value: Int? = null): RootTriggerObjectiveAddValueCommand {
        return RootTriggerObjectiveAddValueCommand(this, value)
    }

    operator fun invoke(value: Int? = null): RootTriggerObjectiveAddValueCommand {
        return value(value)
    }
}

class RootTriggerObjectiveSetValueCommand(
    parent: CommandNode,
    value: Int? = null
): CommandArgument(parent, value)

class RootTriggerObjectiveSetCommand(
    parent: CommandNode,
    literal: String? = "set"
): CommandLiteral(parent, literal) {
    fun value(value: Int? = null): RootTriggerObjectiveSetValueCommand {
        return RootTriggerObjectiveSetValueCommand(this, value)
    }

    operator fun invoke(value: Int? = null): RootTriggerObjectiveSetValueCommand {
        return value(value)
    }
}

class RootTriggerObjectiveCommand(
    parent: CommandNode,
    objective: String
): CommandArgument(parent, objective) {
    val add = RootTriggerObjectiveAddCommand(this)
    val set = RootTriggerObjectiveSetCommand(this)
}

class RootTriggerCommand(
    parent: CommandNode?,
    literal: String? = "trigger"
): CommandLiteral(parent, literal) {
    fun objective(objective: String): RootTriggerObjectiveCommand {
        return RootTriggerObjectiveCommand(this, objective)
    }

    operator fun invoke(objective: String): RootTriggerObjectiveCommand {
        return objective(objective)
    }
}
val trigger = RootTriggerCommand(null)