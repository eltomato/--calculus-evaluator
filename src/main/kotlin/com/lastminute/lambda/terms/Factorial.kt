package com.lastminute.lambda.terms

import com.lastminute.lambda.`_`
import com.lastminute.lambda.λ

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