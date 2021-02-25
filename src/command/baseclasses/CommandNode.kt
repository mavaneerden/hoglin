package command.baseclasses

abstract class CommandNode(
    private val parent: CommandNode? = null,
    private val argumentOrLiteral: Any?
) {
    companion object {
        const val ARG_LIT_SEPARATOR = " "
    }

    /**
     * Get the arguments and literals of `this` node and its parents.
     *
     * @return The arguments and literals of the node and its parents.
     */
    private fun getArgumentsAndLiterals(): ArrayList<Any> {
        return ArrayList<Any>().apply {
            if (parent != null) {
                addAll(parent.getArgumentsAndLiterals())
            }
            if (argumentOrLiteral != null) {
                add(argumentOrLiteral)
            }
        }
    }

    /**
     * Separate the arguments and literals of `this` with a space.
     *
     * @return Space-separated arguments and literals.
     */
    override fun toString(): String {
        return getArgumentsAndLiterals().joinToString(ARG_LIT_SEPARATOR)
    }
}