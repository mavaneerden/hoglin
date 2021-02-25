package utilities

import kotlin.math.ceil

const val COMPOUND_SEPARATOR: String = ", "
const val ARRAY_PREFIX_SEPARATOR: String = "; "

fun capitalToCamel(string: String): String {
    return string.toLowerCase().replace(Regex("_[a-z]")) { result -> result.value[1].toUpperCase().toString() }
}

fun capitalToSnake(string: String): String {
    return string.toLowerCase()
}

fun capitalToDots(string: String): String {
    return string.toLowerCase().replace('_', '.')
}

fun argsToJSONString(vararg args: String, addBrackets: Boolean = true): String {
    val lastElementEmpty = args.last() == ""
    val arraySize: Int = if (!lastElementEmpty) ceil(args.size.toDouble() / 2.0).toInt() else args.size / 2
    val transformedArgs: Array<String> = Array(arraySize) { "" }
    val prefix = if (addBrackets) "{" else ""
    val suffix = if (addBrackets) "}" else ""

    for (i in args.indices step 2) {
        if (i >= args.size - 1) {
            if (args.size % 2 != 0 && !lastElementEmpty) {
                transformedArgs[arraySize - 1] = args.last()
            }
            break
        }

        transformedArgs[i / 2] = "\"${args[i]}\": ${args[i + 1]}"
    }

    return transformedArgs.joinToString(COMPOUND_SEPARATOR, prefix, suffix)
}

fun toQuotedString(obj: Any): String {
    return "\"$obj\""
}

fun <K, V> mapToString(map: Map<K, V>): String {
    val strings: Array<String> = Array(map.size) { "" }

    map.entries.forEachIndexed { index, entry -> strings[index] = "${entry.key}=${entry.value}" }
    return strings.joinToString(COMPOUND_SEPARATOR)
}

fun <T : Any> arrayArgumentToString(arguments: Array<T>?, argumentName: String): String? {
    return if (arguments!!.isEmpty()) {
        null
    }
    else {
        val strings: Array<String> = Array(arguments.size) { "" }

        for (i in arguments.indices) {
            strings[i] = "$argumentName=${arguments[i]}"
        }

        strings.joinToString(COMPOUND_SEPARATOR)
    }
}

fun <T : Any> nullableArrayArgumentToString(arguments: Array<T?>?, argumentNames: Array<String>): String? {
    return if (arguments!!.isEmpty()) {
        null
    }
    else {
        val argumentsMap: MutableMap<String, T> = mutableMapOf()

        for (i in arguments.indices) {
            val argument = arguments[i]

            if (argument != null) {
                argumentsMap[argumentNames[i]] = argument
            }
        }

        mapToString(argumentsMap)
    }
}