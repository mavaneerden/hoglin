package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector
abstract class RootTeleportCommandRedirect(
    parent: CommandNode?,
    argOrLiteral: Any?
): CommandNode(parent, argOrLiteral) {
    fun redirect(): RootTeleportCommand {
        return RootTeleportCommand(this, null)
    }
}


class RootTpCommand(
    parent: CommandNode?,
    literal: String? = "tp"
): RootTeleportCommandRedirect(parent, literal)
val tp = RootTpCommand(null).redirect()