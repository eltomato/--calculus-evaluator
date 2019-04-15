package com.lastminute.lambda.terms

import com.lastminute.lambda.`_`
import com.lastminute.lambda.λ

val pairOf =
    λ("a") { a ->
        λ("b") { b ->
            λ("pair") { pair ->
                pair _ a _ b
            }
        }
    }

val first =
    λ("pair") { pair ->
        pair _ tru3
    }

val second =
    λ("pair") { pair ->
        pair _ fals3
    }

val pairStep =
    λ("pair") { pair ->
        pairOf _ (second _ pair) _ (succ _ (second _ pair))
    }