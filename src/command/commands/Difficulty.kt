package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootDifficultyEasyCommand(
    parent: CommandNode,
    literal: String? = "easy"
): CommandLiteral(parent, literal)

class RootDifficultyHardCommand(
    parent: CommandNode,
    literal: String? = "hard"
): CommandLiteral(parent, literal)

class RootDifficultyNormalCommand(
    parent: CommandNode,
    literal: String? = "normal"
): CommandLiteral(parent, literal)

class RootDifficultyPeacefulCommand(
    parent: CommandNode,
    literal: String? = "peaceful"
): CommandLiteral(parent, literal)

class RootDifficultyCommand(
    parent: CommandNode?,
    literal: String? = "difficulty"
): CommandLiteral(parent, literal) {
    val easy = RootDifficultyEasyCommand(this)
    val hard = RootDifficultyHardCommand(this)
    val normal = RootDifficultyNormalCommand(this)
    val peaceful = RootDifficultyPeacefulCommand(this)
}
val difficulty = RootDifficultyCommand(null)