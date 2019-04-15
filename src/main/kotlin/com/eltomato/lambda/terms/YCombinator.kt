package com.eltomato.lambda.terms

import com.eltomato.lambda.`_`
import com.eltomato.lambda.λ

val Y = λ("f") { f ->
    λ("x") { x -> f _ (x _ x) } _ λ("x") { x -> f _ (x _ x) }
}

//    fun <In, Out> y(f: (_: (n: In) -> Out) -> (n: In) -> Out): (n: In) -> Out = { f(y(f))(it) }
//    val reduce = y<LambdaExpression, LambdaExpression> { f ->
//        {
//            val reductionResult = β-reduction(it)
//            if (reductionResult == it) {
//                reductionResult
//            } else {
//                f(reductionResult)
//            }
//        }
//    }