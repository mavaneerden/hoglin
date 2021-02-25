package block


class Block(private val name: String, nbtFunction: (() -> String)?, vararg properties: Any?) {
    private val nbt: String? = nbtFunction?.let { it() }
    private val properties: Array<Any> = properties.filterNotNull().toTypedArray()

    override fun toString(): String {
        val propertiesString = if (properties.isNotEmpty()) properties.contentToString() else ""

        return "$name$propertiesString$nbt"
    }
}