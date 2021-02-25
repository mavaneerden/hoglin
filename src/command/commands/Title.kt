package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootTitleTargetsActionbarTitleCommand(
    parent: CommandNode,
    title: String
): CommandArgument(parent, title)

class RootTitleTargetsActionbarCommand(
    parent: CommandNode
): CommandLiteral(parent, "actionbar") {
    fun title(title: String): RootTitleTargetsActionbarTitleCommand {
        return RootTitleTargetsActionbarTitleCommand(this, title)
    }

    operator fun invoke(title: String): RootTitleTargetsActionbarTitleCommand {
        return title(title)
    }
}

class RootTitleTargetsClearCommand(
    parent: CommandNode
): CommandLiteral(parent, "clear")

class RootTitleTargetsResetCommand(
    parent: CommandNode
): CommandLiteral(parent, "reset")

class RootTitleTargetsSubtitleTitleCommand(
    parent: CommandNode,
    title: String
): CommandArgument(parent, title)

class RootTitleTargetsSubtitleCommand(
    parent: CommandNode
): CommandLiteral(parent, "subtitle") {
    fun title(title: String): RootTitleTargetsSubtitleTitleCommand {
        return RootTitleTargetsSubtitleTitleCommand(this, title)
    }

    operator fun invoke(title: String): RootTitleTargetsSubtitleTitleCommand {
        return title(title)
    }
}

class RootTitleTargetsTimesFadeInStayFadeOutCommand(
    parent: CommandNode,
    fadeOut: Int
): CommandArgument(parent, fadeOut)

class RootTitleTargetsTimesFadeInStayCommand(
    parent: CommandNode,
    stay: Int
): CommandArgument(parent, stay) {
    fun fadeOut(fadeOut: Int): RootTitleTargetsTimesFadeInStayFadeOutCommand {
        return RootTitleTargetsTimesFadeInStayFadeOutCommand(this, fadeOut)
    }
}

class RootTitleTargetsTimesFadeInCommand(
    parent: CommandNode,
    fadeIn: Int
): CommandArgument(parent, fadeIn) {
    fun stay(stay: Int): RootTitleTargetsTimesFadeInStayCommand {
        return RootTitleTargetsTimesFadeInStayCommand(this, stay)
    }
}

class RootTitleTargetsTimesCommand(
    parent: CommandNode
): CommandLiteral(parent, "times") {
    fun fadeIn(fadeIn: Int): RootTitleTargetsTimesFadeInCommand {
        return RootTitleTargetsTimesFadeInCommand(this, fadeIn)
    }

    operator fun invoke(fadeIn: Int, stay: Int, fadeOut: Int): RootTitleTargetsTimesFadeInStayFadeOutCommand {
        return fadeIn(fadeIn).stay(stay).fadeOut(fadeOut)
    }
}

class RootTitleTargetsTitleTitleCommand(
    parent: CommandNode,
    title: String
): CommandArgument(parent, title)

class RootTitleTargetsTitleCommand(
    parent: CommandNode
): CommandLiteral(parent, "title") {
    fun title(title: String): RootTitleTargetsTitleTitleCommand {
        return RootTitleTargetsTitleTitleCommand(this, title)
    }

    operator fun invoke(title: String): RootTitleTargetsTitleTitleCommand {
        return title(title)
    }
}

class RootTitleTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    val actionbar = RootTitleTargetsActionbarCommand(this)
    val clear = RootTitleTargetsClearCommand(this)
    val reset = RootTitleTargetsResetCommand(this)
    val subtitle = RootTitleTargetsSubtitleCommand(this)
    val times = RootTitleTargetsTimesCommand(this)
    val title = RootTitleTargetsTitleCommand(this)
}

class RootTitleCommand(
    parent: CommandNode?,
    literal: String? = "title"
): CommandLiteral(parent, literal) {
    fun targets(targets: Selector): RootTitleTargetsCommand {
        return RootTitleTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector): RootTitleTargetsCommand {
        return targets(targets)
    }
}
val title = RootTitleCommand(null)