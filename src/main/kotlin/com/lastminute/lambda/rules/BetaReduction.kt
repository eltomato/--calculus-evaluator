package com.lastminute.lambda.rules

import com.lastminute.lambda.LambdaExpression
import com.lastminute.lambda.LambdaExpression.*

fun `β-reduction`(lambdaExpression: LambdaExpression): LambdaExpression {
    return when (lambdaExpression) {
        is Variable -> lambdaExpression
        is Abstraction -> Abstraction(lambdaExpression.variable, `β-reduction`(lambdaExpression.expression))
        is Application -> if (lambdaExpression.first is Abstraction)
            substitute(lambdaExpression.first.variable, lambdaExpression.second, lambdaExpression.first.expression)
        else
            Application(`β-reduction`(lambdaExpression.first), `β-reduction`(lambdaExpression.second))
    }
}

fun substitute(toReplace: String, with: LambdaExpression, inExpression: LambdaExpression): LambdaExpression {
    return when (inExpression) {
        is Variable -> if (inExpression.variable == toReplace) with else inExpression
        is Abstraction ->
            if (inExpression.variable != toReplace)
                Abstraction(inExpression.variable, substitute(toReplace, with, inExpression.expression))
            else
                inExpression
        is Application -> Application(
            substitute(toReplace, with, inExpression.first),
            substitute(toReplace, with, inExpression.second)
        )
    }
}