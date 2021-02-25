package json

import utilities.COMPOUND_SEPARATOR

class JSONText(private vararg val components: JSONTextComponent, var resetStyle: Boolean = true) {
    override fun toString(): String {
        return "[${if (resetStyle) "\"\", " else ""}${components.joinToString(COMPOUND_SEPARATOR)}]"
    }
}