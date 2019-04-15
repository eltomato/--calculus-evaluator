package com.lastminute.lambda

import com.lastminute.lambda.LambdaExpression.*

sealed class LambdaExpression {
    data class Variable(val variable: String) : LambdaExpression() {
        override fun toString(): String {
            return variable
        }
    }

    data class Abstraction(val variable: String, val expression: LambdaExpression) : LambdaExpression() {
        override fun toString(): String {
            return "λ$variable.$expression"
        }
    }

    data class Application(val first: LambdaExpression, val second: LambdaExpression) : LambdaExpression() {
        override fun toString(): String {
            return "($first $second)"
        }
    }
}

fun λ(variable: String, expression: (Variable) -> LambdaExpression): LambdaExpression = Abstraction(variable, expression(Variable(variable)))
infix fun LambdaExpression.`_`(other: LambdaExpression) = Application(this, other)

