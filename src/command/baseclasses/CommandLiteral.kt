package command.baseclasses

abstract class CommandLiteral(
    parent: CommandNode?,
    private val literal: String?
): CommandNode(parent, literal)