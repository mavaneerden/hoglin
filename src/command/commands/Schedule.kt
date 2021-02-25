package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootScheduleClearFunctionCommand(
    parent: CommandNode,
    function: String
): CommandArgument(parent, function)

class RootScheduleClearCommand(
    parent: CommandNode
): CommandLiteral(parent, "clear") {
    fun function(function: String): RootScheduleClearFunctionCommand {
        return RootScheduleClearFunctionCommand(this, function)
    }

    operator fun invoke(function: String): RootScheduleClearFunctionCommand {
        return function(function)
    }
}

class RootScheduleFunctionFunctionTimeAppendCommand(
    parent: CommandNode,
    literal: String? = "append"
): CommandLiteral(parent, literal)

class RootScheduleFunctionFunctionTimeReplaceCommand(
    parent: CommandNode,
    literal: String? = "replace"
): CommandLiteral(parent, literal)

class RootScheduleFunctionFunctionTimeCommand(
    parent: CommandNode,
    time: String
): CommandArgument(parent, time) {
    val append = RootScheduleFunctionFunctionTimeAppendCommand(this)
    val replace = RootScheduleFunctionFunctionTimeReplaceCommand(this)
}

class RootScheduleFunctionFunctionCommand(
    parent: CommandNode,
    function: String
): CommandArgument(parent, function) {
    fun time(time: String): RootScheduleFunctionFunctionTimeCommand {
        return RootScheduleFunctionFunctionTimeCommand(this, time)
    }
}

class RootScheduleFunctionCommand(
    parent: CommandNode
): CommandLiteral(parent, "function") {
    fun function(function: String): RootScheduleFunctionFunctionCommand {
        return RootScheduleFunctionFunctionCommand(this, function)
    }

    operator fun invoke(function: String, time: String): RootScheduleFunctionFunctionTimeCommand {
        return function(function).time(time)
    }
}

class RootScheduleCommand(
    parent: CommandNode?,
    literal: String? = "schedule"
): CommandLiteral(parent, literal) {
    val clear = RootScheduleClearCommand(this)
    val function = RootScheduleFunctionCommand(this)
}
val schedule = RootScheduleCommand(null)