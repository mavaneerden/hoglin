package control

import control.conditions.ConditionOperand

fun ifBlock(condition: ConditionOperand, expression: () -> Unit) {
    println("$condition")
}

fun elseIfBlock(condition: ConditionOperand, expression: () -> Unit) {

}

fun elseBlock(expression: () -> Unit) {

}