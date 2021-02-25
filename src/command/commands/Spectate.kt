package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootSpectateTargetPlayerCommand(
    parent: CommandNode,
    player: Selector? = null
): CommandArgument(parent, player)

class RootSpectateTargetCommand(
    parent: CommandNode,
    target: Selector? = null
): CommandArgument(parent, target) {
    fun player(player: Selector? = null): RootSpectateTargetPlayerCommand {
        return RootSpectateTargetPlayerCommand(this, player)
    }
}

class RootSpectateCommand(
    parent: CommandNode?,
    literal: String? = "spectate"
): CommandLiteral(parent, literal) {
    fun target(target: Selector? = null): RootSpectateTargetCommand {
        return RootSpectateTargetCommand(this, target)
    }

    operator fun invoke(target: Selector? = null, player: Selector? = null): RootSpectateTargetPlayerCommand {
        return target(target).player(player)
    }
}
val spectate = RootSpectateCommand(null)