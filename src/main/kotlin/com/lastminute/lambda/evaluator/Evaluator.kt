package com.lastminute.lambda.evaluator

import com.lastminute.lambda.*
import com.lastminute.lambda.terms.*
import com.lastminute.lambda.rules.`β-reduction`

tailrec fun reduce(lambdaExpression: LambdaExpression, stepAction: (LambdaExpression) -> Unit): LambdaExpression {
    val reductionResult = `β-reduction`(lambdaExpression)
    return if (reductionResult == lambdaExpression) {
        reductionResult
    } else {
        stepAction(reductionResult)
        reduce(reductionResult, stepAction)
    }
}

fun main(args: Array<String>) {

    val program = Y _ fact _ three

    println(program)
    println(reduce(program) { println("= $it") })
}