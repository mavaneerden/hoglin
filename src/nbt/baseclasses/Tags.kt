package nbt.baseclasses

import utilities.COMPOUND_SEPARATOR
import javax.xml.stream.events.Comment

class TagBoolean(
    name: String
    // value: Boolean
// ): NBTTag(name, value)
): NBTTag<Boolean>(name)

open class TagByte(
    name: String
    // value: Byte
// ): NBTTag(name, value, 'b')
): NBTTag<Byte>(name, 'b')

class TagShort(
    name: String
    // value: Short
// ): NBTTag(name, value, 's')
): NBTTag<Short>(name, 's')

class TagInt(
    name: String
    // value: Int
): NBTTag<Int>(name)

class TagLong(
    name: String
    // value: Long
// ): NBTTag(name, value, 'L')
): NBTTag<Long>(name, 'L')

class TagFloat(
    name: String
    // value: Float
// ): NBTTag(name, value, 'f')
): NBTTag<Float>(name, 'f')

class TagDouble(
    name: String
    // value: Double
// ): NBTTag(name, value, 'd')
): NBTTag<Double>(name, 'd')

open class TagString(
    name: String
    // value: String
// ): NBTTag(name, value)
): NBTTag<String>(name)

class TagByteArray(
    name: String
    // override val value: ByteArray
// ): NBTTagArray(name, value, prefix = 'B' ) {
): NBTTagArray<ByteArray>(name, prefix = 'B' ) {
    // override var value: ByteArray? = null

    override operator fun invoke(vararg value: Byte): TagByteArray {
        this.value = value

        return this
    }

    override fun toString(): String {
        return super.getString(value!!.joinToString(COMPOUND_SEPARATOR))
    }
}

class TagIntArray(
    name: String
    // override val value: IntArray
// ): NBTTagArray(name, value, prefix = 'I' ) {
): NBTTagArray<IntArray>(name, prefix = 'I' ) {

    override operator fun invoke(vararg value: Int): TagIntArray {
        this.value = value

        return this
    }

    override fun toString(): String {
        return super.getString(value!!.joinToString(COMPOUND_SEPARATOR))
    }
}

class TagLongArray(
    name: String
    // override val value: LongArray
// ): NBTTagArray(name, value, prefix = 'L' ) {
): NBTTagArray<LongArray>(name, prefix = 'L' ) {
    override operator fun invoke(vararg value: Long): TagLongArray {
        this.value = value

        return this
    }

    override fun toString(): String {
        return super.getString(value!!.joinToString(COMPOUND_SEPARATOR))
    }
}

class TagList<T>(
    name: String
    // public override val value: Array<out T>
// ) : NBTTagArray(name, value), Iterable<T> {
) : NBTTagArray<Array<out T>>(name), Iterable<T> {
    private var valueString = ""

    override var value: Array<out T>? = null
    set(value) {
        valueString = value!!.joinToString(COMPOUND_SEPARATOR) {
            if (it is String) {
                "\"$it\""
            }
            else {
                it.toString()
            }
        }

        field = value
    }

    override operator fun invoke(vararg value: T): TagList<T> {
        this.value = value

        return this
    }
    // operator fun invoke(vararg value: Compound<*>): TagList<T> {
    //     println(value)
    //     return this
    // }
    // operator fun invoke(vararg value: Compound<T>): TagList<T> {
    //     val newValue = value.map { TagCompound<T>("")(it) }.toTypedArray()
    //     println(newValue)
    //     this.value = newValue as Array<out T>
    //
    //     return this
    // }

    operator fun get(index: Int) {

    }
    // inline operator fun <reified R> get(noinline compound: Compound<R>): R {
    //     return createGenericInstance("", compound)
    // }

    override fun toString(): String {

        return super.getString(valueString)
    }

    override fun iterator(): Iterator<T> {
        return TagListIterator()
    }

    inner class TagListIterator: Iterator<T> {
        val iterator = value!!.iterator()

        override fun hasNext(): Boolean {
            return iterator.hasNext()
        }

        override fun next(): T {
            return iterator.next()
        }
    }
}

open class TagCompound<T>(
    name: String
    // override val value: Compound<T>
// ): NBTTag(name, value) {
): NBTTag<Compound<T>>(name) {
    val children = mutableSetOf<NBTTag<*>>()

    fun <R: NBTTag<*>> registerTag(tag: R): R {
        println("AAAAAAAAAAAAa")
        println(tag)
        children.add(tag)
        return tag
    }

    // inline fun <reified T> registerTag(list: TagList<Compound<T>>): TagList<Compound<T>> {
    //     // val newValue = list.value.map { createGenericInstance<T>("", it) }.toTypedArray()
    //     // this.children.add(TagList(list.name, newValue))
    // }

    @Suppress("UNCHECKED_CAST")
    override fun toString(): String {
        (value!! as TagCompound<T>.() -> Unit)()
        return "$nameString{${children.joinToString(COMPOUND_SEPARATOR)}}"
    }
}

typealias Compound<T> = T.() -> Unit

inline fun <reified T> Compound<T>.getInstance(): T {
    return createGenericInstance("")
}

/**
 * TODO: Move to util
 * https://stackoverflow.com/a/59229405
 */
inline fun <reified T> createGenericInstance(vararg value: Any) : T {
    val constructor = T::class.constructors.first()
    return constructor.call(*value)
}