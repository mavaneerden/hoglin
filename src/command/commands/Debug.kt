package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootDebugReportCommand(
    parent: CommandNode
): CommandLiteral(parent, "report")

class RootDebugStartCommand(
    parent: CommandNode
): CommandLiteral(parent, "start")

class RootDebugStopCommand(
    parent: CommandNode
): CommandLiteral(parent, "stop")

class RootDebugCommand(
    parent: CommandNode?,
    literal: String? = "debug"
): CommandLiteral(parent, literal) {
    val report = RootDebugReportCommand(this)
    val start = RootDebugStartCommand(this)
    val stop = RootDebugStopCommand(this)
}
val debug = RootDebugCommand(null)