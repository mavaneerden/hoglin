package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector
abstract class RootExperienceCommandRedirect(
    parent: CommandNode?,
    argOrLiteral: Any?
): CommandNode(parent, argOrLiteral) {
    fun redirect(): RootExperienceCommand {
        return RootExperienceCommand(this, null)
    }
}


class RootXpCommand(
    parent: CommandNode?,
    literal: String? = "xp"
): RootExperienceCommandRedirect(parent, literal)
val xp = RootXpCommand(null).redirect()