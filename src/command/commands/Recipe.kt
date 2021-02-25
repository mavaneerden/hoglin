package command.commands

import command.baseclasses.CommandArgument
import command.baseclasses.CommandLiteral
import command.baseclasses.CommandNode
import vector.Coordinates
import target.Selector

class RootRecipeGiveTargetsAllCommand(
    parent: CommandNode
): CommandLiteral(parent, "*")

class RootRecipeGiveTargetsRecipeCommand(
    parent: CommandNode,
    recipe: String
): CommandArgument(parent, recipe)

class RootRecipeGiveTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    val all = RootRecipeGiveTargetsAllCommand(this)

        fun recipe(recipe: String): RootRecipeGiveTargetsRecipeCommand {
        return RootRecipeGiveTargetsRecipeCommand(this, recipe)
    }
}

class RootRecipeGiveCommand(
    parent: CommandNode
): CommandLiteral(parent, "give") {
    fun targets(targets: Selector): RootRecipeGiveTargetsCommand {
        return RootRecipeGiveTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector): RootRecipeGiveTargetsCommand {
        return targets(targets)
    }

    operator fun invoke(targets: Selector, recipe: String): RootRecipeGiveTargetsRecipeCommand {
        return targets(targets).recipe(recipe)
    }
}

class RootRecipeTakeTargetsAllCommand(
    parent: CommandNode
): CommandLiteral(parent, "*")

class RootRecipeTakeTargetsRecipeCommand(
    parent: CommandNode,
    recipe: String
): CommandArgument(parent, recipe)

class RootRecipeTakeTargetsCommand(
    parent: CommandNode,
    targets: Selector
): CommandArgument(parent, targets) {
    val all = RootRecipeTakeTargetsAllCommand(this)

        fun recipe(recipe: String): RootRecipeTakeTargetsRecipeCommand {
        return RootRecipeTakeTargetsRecipeCommand(this, recipe)
    }
}

class RootRecipeTakeCommand(
    parent: CommandNode
): CommandLiteral(parent, "take") {
    fun targets(targets: Selector): RootRecipeTakeTargetsCommand {
        return RootRecipeTakeTargetsCommand(this, targets)
    }

    operator fun invoke(targets: Selector): RootRecipeTakeTargetsCommand {
        return targets(targets)
    }

    operator fun invoke(targets: Selector, recipe: String): RootRecipeTakeTargetsRecipeCommand {
        return targets(targets).recipe(recipe)
    }
}

class RootRecipeCommand(
    parent: CommandNode?,
    literal: String? = "recipe"
): CommandLiteral(parent, literal) {
    val give = RootRecipeGiveCommand(this)
    val take = RootRecipeTakeCommand(this)
}
val recipe = RootRecipeCommand(null)