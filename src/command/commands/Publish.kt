package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootPublishPortCommand(
    parent: CommandNode,
    port: Int? = null
): CommandArgument(parent, port)

class RootPublishCommand(
    parent: CommandNode?,
    literal: String? = "publish"
): CommandLiteral(parent, literal) {
    fun port(port: Int? = null): RootPublishPortCommand {
        return RootPublishPortCommand(this, port)
    }

    operator fun invoke(port: Int? = null): RootPublishPortCommand {
        return port(port)
    }
}
val publish = RootPublishCommand(null)