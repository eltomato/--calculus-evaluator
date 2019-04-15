package com.eltomato.lambda.rules

import com.eltomato.lambda.LambdaExpression

tailrec fun reduce(lambdaExpression: LambdaExpression, stepAction: (LambdaExpression) -> Unit): LambdaExpression {
    val reductionResult = `β-reduction`(lambdaExpression)
    return if (reductionResult == lambdaExpression) {
        reductionResult
    } else {
        stepAction(reductionResult)
        reduce(reductionResult, stepAction)
    }
}