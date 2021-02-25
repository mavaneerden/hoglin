package json

class ClickEvent(val action: ClickEventAction, val contents: String): JSONTextComponent() {

}

class HoverEvent(
    val hoverEventAction: HoverEventAction,
    val text: JSONTextComponent? = null,
    val entity: String? = null, // TODO: Make Entity type or something
    val item: String? = null // TODO: Make Item type or something
): JSONTextComponent() {
    init {
        if (!((text != null) xor (entity != null) xor (item == null))) {
            throw IllegalArgumentException("Must specify exactly one of 'text', 'entity' or 'item'.")
        }
        else if (text != null && hoverEventAction != HoverEventAction.SHOW_TEXT) {
            throw IllegalArgumentException("'text' only works with the 'SHOW_TEXT' action.")
        }
        else if (entity != null && hoverEventAction != HoverEventAction.SHOW_ENTITY) {
            throw IllegalArgumentException("'entity' only works with the 'SHOW_ENTITY' action.")
        }
        else if (item != null && hoverEventAction != HoverEventAction.SHOW_ITEM) {
            throw IllegalArgumentException("'item' only works with the 'SHOW_ITEM' action.")
        }
    }
}