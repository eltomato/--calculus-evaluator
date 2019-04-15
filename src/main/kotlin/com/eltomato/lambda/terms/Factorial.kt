package com.eltomato.lambda.terms

import com.eltomato.lambda.`_`
import com.eltomato.lambda.λ

//val fact =
//    λ("n") { n ->
//        eef _ (isZero _ n) _ one _ (multiply _ n _ (fact _ (pred _ n)))
//    }

val fact =
    λ("f") { f ->
        λ("n") { n ->
            eef _ (isZero _ n) _ one _ (multiply _ n _ (f _ (pred _ n)))
        }
    }