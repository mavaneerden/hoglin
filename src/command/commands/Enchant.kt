package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootEnchantTargetsEnchantmentLevelCommand(
    parent: CommandNode,
    level: Int? = null
): CommandArgument(parent, level)

class RootEnchantTargetsEnchantmentCommand(
    parent: CommandNode,
    enchantment: String
): CommandArgument(parent, enchantment) {
    fun level(level: Int? = null): RootEnchantTargetsEnchantmentLevelCommand {
        return RootEnchantTargetsEnchantmentLevelCommand(this, level)
    }
}

class RootEnchantTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    fun enchantment(enchantment: String): RootEnchantTargetsEnchantmentCommand {
        return RootEnchantTargetsEnchantmentCommand(this, enchantment)
    }
}

class RootEnchantCommand(
    parent: CommandNode?,
    literal: String? = "enchant"
): CommandLiteral(parent, literal) {
    fun targets(targets: Selector): RootEnchantTargetsCommand {
        return RootEnchantTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector, enchantment: String, level: Int? = null): RootEnchantTargetsEnchantmentLevelCommand {
        return targets(targets).enchantment(enchantment).level(level)
    }
}
val enchant = RootEnchantCommand(null)