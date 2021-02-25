package control.conditions


abstract class ConditionOperand {
    infix fun and(condition: ConditionOperand): ConditionNode {
        return ConditionNode(ConditionOperation.AND, this, condition)
    }

    infix fun or(condition: ConditionOperand): ConditionNode {
        return ConditionNode(ConditionOperation.OR, this, condition)
    }

    abstract operator fun not(): ConditionOperand
}


class Condition(
    private val type: ConditionType,
    private val data: ConditionData,
    private val value: Boolean = true
): ConditionOperand() {
    companion object {
        fun createScoreCondition(data: ScoreConditionData): Condition {
            return Condition(ConditionType.SCORE, data)
        }
    }

    override operator fun not(): ConditionOperand {
        return Condition(this.type, this.data, false)
    }

    override fun toString(): String {
        // TODO: Move this to helper
        val prefix = if (value) "if" else "unless"

        return "$prefix $type $data"
    }
}


class ConditionNode(
    val operation: ConditionOperation,
    val leftChild: ConditionOperand,
    val rightChild: ConditionOperand
): ConditionOperand() {
    /**
     * Invert the condition using De Morgan's laws.
     */
    override fun not(): ConditionOperand {
        return ConditionNode(ConditionOperation.inverse(operation), !leftChild, !rightChild)
    }

    override fun toString(): String {
        return "($leftChild $operation $rightChild)"
    }
}