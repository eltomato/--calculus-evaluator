package com.lastminute.lambda.rules

import com.lastminute.lambda.LambdaExpression
import com.lastminute.lambda.LambdaExpression.*

fun betaReduction(lambdaExpression: LambdaExpression): LambdaExpression {
    return when (lambdaExpression) {
        is Variable -> lambdaExpression
        is Abstraction -> Abstraction(lambdaExpression.variable, betaReduction(lambdaExpression.expression))
        is Application -> if (lambdaExpression.first is Abstraction) replace(lambdaExpression.first.variable, lambdaExpression.second, lambdaExpression.first.expression) else Application(betaReduction(lambdaExpression.first), betaReduction(lambdaExpression.second))
    }
}

fun replace(toReplace: String, with: LambdaExpression, inExpression: LambdaExpression): LambdaExpression {
    return when (inExpression) {
        is Variable -> if (inExpression.variable == toReplace) with else inExpression
        is Abstraction ->
            if (inExpression.variable != toReplace)
                Abstraction(inExpression.variable, replace(toReplace, with, inExpression.expression))
            else
                inExpression
        is Application -> Application(
            replace(toReplace, with, inExpression.first),
            replace(toReplace, with, inExpression.second)
        )
    }
}