package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector
abstract class RootMsgCommandRedirect(
    parent: CommandNode?,
    argOrLiteral: Any?
): CommandNode(parent, argOrLiteral) {
    fun redirect(): RootMsgCommand {
        return RootMsgCommand(this, null)
    }
}


class RootTellCommand(
    parent: CommandNode?,
    literal: String? = "tell"
): RootMsgCommandRedirect(parent, literal)
val tell = RootTellCommand(null).redirect()