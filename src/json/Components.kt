package json

import vector.Coordinates
import nbt.NBTPath
import scoreboard.Objective
import scoreboard.Score
import target.Selector
import target.Target
import utilities.argsToJSONString
import utilities.toQuotedString

abstract class JSONTextComponent {
    private var extraComponents: JSONText? = null

    fun extra(vararg components: JSONTextComponent, resetStyle: Boolean = true): JSONTextComponent {
        extraComponents = JSONText(*components, resetStyle = resetStyle)
        return this
    }

    private fun getExtraString(): String {
        return if (extraComponents != null) {
            argsToJSONString("extra", extraComponents.toString(), addBrackets = false)
        }
        else {
            ""
        }
    }

    fun getString(vararg args: String): String {
        return argsToJSONString(*args, getExtraString())
    }
}

class TextComponent(private val text: String): JSONTextComponent() {
    override fun toString(): String {
        return getString("text", toQuotedString(text))
    }
}

class TranslateComponent(private val key: String, private val with: JSONText): JSONTextComponent() {
    constructor(key: String, vararg with: JSONTextComponent): this(key, JSONText(*with))

    init {
        with.resetStyle = false
    }

    override fun toString(): String {
        return getString("translate", toQuotedString(key), "with", with.toString())
    }
}

class ScoreComponent(private val score: Score, private val value: Int? = null): JSONTextComponent() {
    constructor(name: Target, objective: Objective, value: Int? = null): this(Score(name, objective), value)

    override fun toString(): String {
        val baseComponent: Array<String> = arrayOf(
            "name", toQuotedString(score.holder),
            "objective", toQuotedString(score.objective)
        )

        return if (value == null) {
            getString(*baseComponent)
        }
        else {
            getString(*baseComponent, "value", toQuotedString(value))
        }
    }
}

class SelectorComponent(private val selector: Selector): JSONTextComponent() {
    override fun toString(): String {
        return getString("selector", toQuotedString(selector))
    }
}

class KeybindComponent(private val identifier: KeybindIdentifier): JSONTextComponent() {
    override fun toString(): String {
        return getString("key", toQuotedString(identifier))
    }
}

class NBTComponent(
    private val nbt: NBTPath,
    private val block: Coordinates? = null,
    private val entity: Selector? = null,
    private val storage: String? = null, // TODO: Make Storage type or something
    private val interpret: Boolean? = null
): JSONTextComponent() {
    init {
        if (!((block != null) xor (entity != null) xor (storage != null))) {
            throw IllegalArgumentException("Must specify exactly one of 'block', 'entity' or 'storage'.")
        }
    }

    override fun toString(): String {
        val baseComponent = arrayOf("nbt", toQuotedString(nbt))

        val advancedComponent =  when {
            block != null  -> arrayOf(*baseComponent, "block", toQuotedString(block))
            entity != null -> arrayOf(*baseComponent, "entity", toQuotedString(entity))
            else           -> arrayOf(*baseComponent, "storage", toQuotedString(storage!!))
        }

        return if (interpret != null) {
            getString(*advancedComponent, "interpret", toQuotedString(interpret))
        }
        else {
            getString(*advancedComponent)
        }
    }
}

class InsertionComponent(private val text: String): JSONTextComponent() {
    override fun toString(): String {
        return getString("insertion", toQuotedString(text))
    }
}