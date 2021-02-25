package target

import utilities.capitalToSnake

interface SelectorArgumentEnum {
    var negated: Boolean

    operator fun not(): SelectorArgumentEnum {
        negated = !negated
        return this
    }
}

enum class Gamemode: SelectorArgumentEnum {
    SURVIVAL,
    CREATIVE,
    SPECTATOR,
    ADVENTURE;

    override var negated: Boolean = false

    override fun toString(): String {
        val string: String = capitalToSnake(name)
        return if (negated) "!$string" else string
    }
}

enum class EntityType: SelectorArgumentEnum {
    BAT,
    BLAZE,
    BEE,
    CAT,
    CAVE_SPIDER,
    CHICKEN,
    COD,
    COW,
    CREEPER,
    DOLPHIN,
    DONKEY,
    DROWNED,
    ELDER_GUARDIAN,
    ENDER_DRAGON,
    ENDERMAN,
    ENDERMITE,
    EVOKER,
    FOX,
    GHAST,
    GIANT,
    GUARDIAN,
    HORSE,
    HUSK,
    ILLUSIONER,
    IRON_GOLEM,
    LLAMA,
    MAGMA_CUBE,
    MOOSHROOM,
    MULE,
    OCELOT,
    PANDA,
    PARROT,
    PHANTOM,
    PIG,
    PILLAGER,
    POLAR_BEAR,
    PUFFERFISH,
    RABBIT,
    RAVAGER,
    SALMON,
    SHULKER,
    SILVERFISH,
    SKELETON,
    SKELETON_HORSE,
    SLIME,
    SNOW_GOLEM,
    SPIDER,
    SQUID,
    STRAY,
    TRADER_LLAMA,
    TROPICAL_FISH,
    TURTLE,
    VEX,
    VILLAGER,
    VINDICATOR,
    WANDERING_TRADER,
    WITCH,
    WITHER,
    WITHER_SKELETON,
    WOLF,
    ZOMBIE,
    ZOMBIE_HORSE,
    ZOMBIFIED_PIGLIN,
    ZOMBIE_VILLAGER,
    PIGLIN,
    HOGLIN,
    STRIDER,
    ZOGLIN;

    override var negated: Boolean = false

    override fun toString(): String {
        val string: String = capitalToSnake(name)
        return if (negated) "!$string" else string
    }
}

enum class Sort {
    NEAREST,
    FURTHEST,
    RANDOM,
    ARBITRARY;
}

enum class SelectorVariable {
    ALL_PLAYERS,
    NEAREST_PLAYER,
    RANDOM_PLAYER,
    ALL_ENTITIES,
    SELF;

    override fun toString(): String {
        return when(this) {
            ALL_PLAYERS -> "@a"
            NEAREST_PLAYER -> "@p"
            RANDOM_PLAYER -> "@r"
            ALL_ENTITIES -> "@e"
            SELF -> "@s"
        }
    }
}