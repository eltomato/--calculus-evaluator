package com.eltomato.lambda.terms

import com.eltomato.lambda.`_`
import com.eltomato.lambda.λ

//val fact =
//    λ("n") { n ->
//        eef _ (isZero _ n) _ one _ (multiply _ n _ (fact _ (pred _ n)))
//    }

//val recursive_fact : LambdaExpression =
//            λ("n") { n ->
//                eef _ (isZero _ n) _ one _ (multiply _ n _ (com.eltomato.lambda.terms.recursive_fact _ (pred _ n)))
//            }

private val _fact = λ("f") { f ->
    λ("n") { n ->
        eef _ (isZero _ n) _ one _ (multiply _ n _ (f _ (pred _ n)))
    }
}

val fact = Y _ _fact