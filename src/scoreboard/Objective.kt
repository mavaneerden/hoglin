package scoreboard

import json.JSONText
import utilities.capitalToCamel
import utilities.capitalToDots
import utilities.capitalToSnake

/**
 * Represents a scoreboard objective.
 *
 * @property name Objective name.
 * @property displayName Objective display name.
 * @property renderType Objective render type.
 * @property displaySlot Objective display slot.
 */
class Objective(private val name: String) {
    var displayName: JSONText = JSONText()
        set(value) {
            // TODO: scoreboard objectives modify displayName
            println("scoreboard objectives modify $name displayName $displayName")
            field = value
        }

    var displaySlot: ObjectiveDisplaySlot = ObjectiveDisplaySlot.SIDEBAR
        set(value) {
            // TODO: scoreboard objectives setdisplay
            println("scoreboard objectives setdisplay $displaySlot $name")
            field = value
        }

    var renderType: ObjectiveRenderType = ObjectiveRenderType.default()
        set(value) {
            // TODO: scoreboard objectives modify renderType
            println("scoreboard objectives modify $name renderType $renderType")
            field = value
        }

    override fun toString(): String {
        return this.name
    }
}

enum class ObjectiveRenderType {
    HEARTS,
    INTEGER;

    companion object {
        /**
         * Get the default render type.
         *
         * @return The default render type for all objectives.
         */
        fun default(): ObjectiveRenderType {
            return INTEGER
        }
    }

    override fun toString(): String {
        return capitalToSnake(this.name)
    }
}

enum class ObjectiveDisplaySlot {
    LIST,
    BELOW_NAME,
    SIDEBAR,
    SIDEBAR_TEAM_BLACK,
    SIDEBAR_TEAM_DARK_BLUE,
    SIDEBAR_TEAM_DARK_GREEN,
    SIDEBAR_TEAM_DARK_AQUA,
    SIDEBAR_TEAM_DARK_RED,
    SIDEBAR_TEAM_DARK_PURPLE,
    SIDEBAR_TEAM_BLUE,
    SIDEBAR_TEAM_GREEN,
    SIDEBAR_TEAM_AQUA,
    SIDEBAR_TEAM_RED,
    SIDEBAR_TEAM_LIGHT_PURPLE,
    SIDEBAR_TEAM_YELLOW,
    SIDEBAR_TEAM_WHITE;

    override fun toString(): String {
        return when {
            this.name.contains("SIDEBAR") -> "key.${capitalToDots(this.name)}"
            else -> "key.${capitalToCamel(this.name)}"
        }
    }
}