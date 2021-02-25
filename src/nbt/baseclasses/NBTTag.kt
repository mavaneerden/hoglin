package nbt.baseclasses

import utilities.ARRAY_PREFIX_SEPARATOR

abstract class NBTTag<T>(
    val name: String,
    // protected open val value: Any,
    suffix: Char? = null
) {
    private val suffixString: String = suffix?.toString() ?: ""
    protected val nameString: String = if (name == "") name else "\"$name\": "
    open var value: T? = null

    open operator fun invoke(value: T): NBTTag<T> {
        this.value = value

        return this
    }

    override fun toString(): String {
        val valueString: String = if (value is String) "\"$value\"" else value.toString()

        return "$nameString$valueString$suffixString"
    }
}

abstract class NBTTagArray<T>(
    name: String,
    // value: Any,
    prefix: Char? = null
// ): NBTTag(name, value) {
): NBTTag<T>(name) {
    var prefixString: String = prefix?.toString() ?: ""

    init {
        if (prefix != null) {
            prefixString += ARRAY_PREFIX_SEPARATOR
        }
    }

    protected fun getString(value: String): String {
        return "$nameString[$prefixString$value]"
    }
}