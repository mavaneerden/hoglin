package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector
abstract class RootTeammsgCommandRedirect(
    parent: CommandNode?,
    argOrLiteral: Any?
): CommandNode(parent, argOrLiteral) {
    fun redirect(): RootTeammsgCommand {
        return RootTeammsgCommand(this, null)
    }
}


class RootTmCommand(
    parent: CommandNode?,
    literal: String? = "tm"
): RootTeammsgCommandRedirect(parent, literal)
val tm = RootTmCommand(null).redirect()