package json

import utilities.capitalToCamel
import utilities.capitalToDots
import utilities.capitalToSnake

enum class KeybindIdentifier {
    JUMP,
    SNEAK,
    SPRINT,
    LEFT,
    RIGHT,
    BACK,
    FORWARD,
    ATTACK,
    PICK_ITEM,
    USE,
    DROP,
    HOTBAR_1,
    HOTBAR_2,
    HOTBAR_3,
    HOTBAR_4,
    HOTBAR_5,
    HOTBAR_6,
    HOTBAR_7,
    HOTBAR_8,
    HOTBAR_9,
    INVENTORY,
    SWAP_OFFHAND,
    LOAD_TOOLBAR_ACTIVATOR,
    SAVE_TOOLBAR_ACTIVATOR,
    PLAYERLIST,
    CHAT,
    COMMAND,
    ADVANCEMENTS,
    SCREENSHOT,
    SMOOTH_CAMERA,
    FULLSCREEN,
    TOGGLE_PERSPECTIVE;

    override fun toString(): String {
        return when {
            this.name.contains("HOTBAR") -> "key.${capitalToDots(this.name)}"
            else -> "key.${capitalToCamel(this.name)}"
        }
    }
}

enum class ClickEventAction {
    OPEN_URL,
    OPEN_FILE,
    RUN_COMMAND,
    SUGGEST_COMMAND,
    CHANGE_PAGE,
    COPY_TO_CLIPBOARD
}

enum class HoverEventAction {
    SHOW_TEXT,
    SHOW_ITEM,
    SHOW_ENTITY
}