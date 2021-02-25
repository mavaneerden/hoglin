package control.conditions

enum class ConditionType {
    BLOCK,
    BLOCKS,
    DATA,
    ENTITY,
    PREDICATE,
    SCORE;

    override fun toString(): String {
        return when(this) {
            BLOCK     -> "block"
            BLOCKS    -> "blocks"
            DATA      -> "data"
            ENTITY    -> "entity"
            PREDICATE -> "predicate"
            SCORE     -> "score"
        }
    }
}

enum class ConditionOperation {
    AND,
    OR;

    companion object {
        fun inverse(operation: ConditionOperation): ConditionOperation {
            return when(operation) {
                AND -> OR
                OR -> AND
            }
        }
    }
}