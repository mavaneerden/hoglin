package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootBossbarAddIdNameCommand(
    parent: CommandNode,
    name: String
): CommandArgument(parent, name)

class RootBossbarAddIdCommand(
    parent: CommandNode,
    id: String
): CommandArgument(parent, id) {
    fun name(name: String): RootBossbarAddIdNameCommand {
        return RootBossbarAddIdNameCommand(this, name)
    }
}

class RootBossbarAddCommand(
    parent: CommandNode
): CommandLiteral(parent, "add") {
    fun id(id: String): RootBossbarAddIdCommand {
        return RootBossbarAddIdCommand(this, id)
    }

    operator fun invoke(id: String, name: String): RootBossbarAddIdNameCommand {
        return id(id).name(name)
    }
}

class RootBossbarGetIdMaxCommand(
    parent: CommandNode
): CommandLiteral(parent, "max")

class RootBossbarGetIdPlayersCommand(
    parent: CommandNode
): CommandLiteral(parent, "players")

class RootBossbarGetIdValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value")

class RootBossbarGetIdVisibleCommand(
    parent: CommandNode
): CommandLiteral(parent, "visible")

class RootBossbarGetIdCommand(
    parent: CommandNode,
    id: String
): CommandArgument(parent, id) {
    val max = RootBossbarGetIdMaxCommand(this)
    val players = RootBossbarGetIdPlayersCommand(this)
    val value = RootBossbarGetIdValueCommand(this)
    val visible = RootBossbarGetIdVisibleCommand(this)
}

class RootBossbarGetCommand(
    parent: CommandNode
): CommandLiteral(parent, "get") {
    fun id(id: String): RootBossbarGetIdCommand {
        return RootBossbarGetIdCommand(this, id)
    }

    operator fun invoke(id: String): RootBossbarGetIdCommand {
        return id(id)
    }
}

class RootBossbarListCommand(
    parent: CommandNode
): CommandLiteral(parent, "list")

class RootBossbarRemoveIdCommand(
    parent: CommandNode,
    id: String
): CommandArgument(parent, id)

class RootBossbarRemoveCommand(
    parent: CommandNode
): CommandLiteral(parent, "remove") {
    fun id(id: String): RootBossbarRemoveIdCommand {
        return RootBossbarRemoveIdCommand(this, id)
    }

    operator fun invoke(id: String): RootBossbarRemoveIdCommand {
        return id(id)
    }
}

class RootBossbarSetIdColorBlueCommand(
    parent: CommandNode
): CommandLiteral(parent, "blue")

class RootBossbarSetIdColorGreenCommand(
    parent: CommandNode
): CommandLiteral(parent, "green")

class RootBossbarSetIdColorPinkCommand(
    parent: CommandNode
): CommandLiteral(parent, "pink")

class RootBossbarSetIdColorPurpleCommand(
    parent: CommandNode
): CommandLiteral(parent, "purple")

class RootBossbarSetIdColorRedCommand(
    parent: CommandNode
): CommandLiteral(parent, "red")

class RootBossbarSetIdColorWhiteCommand(
    parent: CommandNode
): CommandLiteral(parent, "white")

class RootBossbarSetIdColorYellowCommand(
    parent: CommandNode
): CommandLiteral(parent, "yellow")

class RootBossbarSetIdColorCommand(
    parent: CommandNode
): CommandLiteral(parent, "color") {
    val blue = RootBossbarSetIdColorBlueCommand(this)
    val green = RootBossbarSetIdColorGreenCommand(this)
    val pink = RootBossbarSetIdColorPinkCommand(this)
    val purple = RootBossbarSetIdColorPurpleCommand(this)
    val red = RootBossbarSetIdColorRedCommand(this)
    val white = RootBossbarSetIdColorWhiteCommand(this)
    val yellow = RootBossbarSetIdColorYellowCommand(this)
}

class RootBossbarSetIdMaxMaxCommand(
    parent: CommandNode,
    max: Int
): CommandArgument(parent, max)

class RootBossbarSetIdMaxCommand(
    parent: CommandNode
): CommandLiteral(parent, "max") {
    fun max(max: Int): RootBossbarSetIdMaxMaxCommand {
        return RootBossbarSetIdMaxMaxCommand(this, max)
    }

    operator fun invoke(max: Int): RootBossbarSetIdMaxMaxCommand {
        return max(max)
    }
}

class RootBossbarSetIdNameNameCommand(
    parent: CommandNode,
    name: String
): CommandArgument(parent, name)

class RootBossbarSetIdNameCommand(
    parent: CommandNode
): CommandLiteral(parent, "name") {
    fun name(name: String): RootBossbarSetIdNameNameCommand {
        return RootBossbarSetIdNameNameCommand(this, name)
    }

    operator fun invoke(name: String): RootBossbarSetIdNameNameCommand {
        return name(name)
    }
}

class RootBossbarSetIdPlayersTargetsCommand(
    parent: CommandNode,
    targets: Selector? = null
): CommandArgument(parent, targets)

class RootBossbarSetIdPlayersCommand(
    parent: CommandNode
): CommandLiteral(parent, "players") {
    fun targets(targets: Selector? = null): RootBossbarSetIdPlayersTargetsCommand {
        return RootBossbarSetIdPlayersTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector? = null): RootBossbarSetIdPlayersTargetsCommand {
        return targets(targets)
    }
}

class RootBossbarSetIdStyleNotched10Command(
    parent: CommandNode
): CommandLiteral(parent, "notched_10")

class RootBossbarSetIdStyleNotched12Command(
    parent: CommandNode
): CommandLiteral(parent, "notched_12")

class RootBossbarSetIdStyleNotched20Command(
    parent: CommandNode
): CommandLiteral(parent, "notched_20")

class RootBossbarSetIdStyleNotched6Command(
    parent: CommandNode
): CommandLiteral(parent, "notched_6")

class RootBossbarSetIdStyleProgressCommand(
    parent: CommandNode
): CommandLiteral(parent, "progress")

class RootBossbarSetIdStyleCommand(
    parent: CommandNode
): CommandLiteral(parent, "style") {
    val notched10 = RootBossbarSetIdStyleNotched10Command(this)
    val notched12 = RootBossbarSetIdStyleNotched12Command(this)
    val notched20 = RootBossbarSetIdStyleNotched20Command(this)
    val notched6 = RootBossbarSetIdStyleNotched6Command(this)
    val progress = RootBossbarSetIdStyleProgressCommand(this)
}

class RootBossbarSetIdValueValueCommand(
    parent: CommandNode,
    value: Int
): CommandArgument(parent, value)

class RootBossbarSetIdValueCommand(
    parent: CommandNode
): CommandLiteral(parent, "value") {
    fun value(value: Int): RootBossbarSetIdValueValueCommand {
        return RootBossbarSetIdValueValueCommand(this, value)
    }

    operator fun invoke(value: Int): RootBossbarSetIdValueValueCommand {
        return value(value)
    }
}

class RootBossbarSetIdVisibleVisibleCommand(
    parent: CommandNode,
    visible: Boolean
): CommandArgument(parent, visible)

class RootBossbarSetIdVisibleCommand(
    parent: CommandNode
): CommandLiteral(parent, "visible") {
    fun visible(visible: Boolean): RootBossbarSetIdVisibleVisibleCommand {
        return RootBossbarSetIdVisibleVisibleCommand(this, visible)
    }

    operator fun invoke(visible: Boolean): RootBossbarSetIdVisibleVisibleCommand {
        return visible(visible)
    }
}

class RootBossbarSetIdCommand(
    parent: CommandNode,
    id: String
): CommandArgument(parent, id) {
    val color = RootBossbarSetIdColorCommand(this)
    val max = RootBossbarSetIdMaxCommand(this)
    val name = RootBossbarSetIdNameCommand(this)
    val players = RootBossbarSetIdPlayersCommand(this)
    val style = RootBossbarSetIdStyleCommand(this)
    val value = RootBossbarSetIdValueCommand(this)
    val visible = RootBossbarSetIdVisibleCommand(this)
}

class RootBossbarSetCommand(
    parent: CommandNode
): CommandLiteral(parent, "set") {
    fun id(id: String): RootBossbarSetIdCommand {
        return RootBossbarSetIdCommand(this, id)
    }

    operator fun invoke(id: String): RootBossbarSetIdCommand {
        return id(id)
    }
}

class RootBossbarCommand(
    parent: CommandNode?,
    literal: String? = "bossbar"
): CommandLiteral(parent, literal) {
    val add = RootBossbarAddCommand(this)
    val get = RootBossbarGetCommand(this)
    val list = RootBossbarListCommand(this)
    val remove = RootBossbarRemoveCommand(this)
    val set = RootBossbarSetCommand(this)
}
val bossbar = RootBossbarCommand(null)