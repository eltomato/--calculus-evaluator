package com.lastminute.lambda.terms

import com.lastminute.lambda.`_`
import com.lastminute.lambda.λ

val zero =
    λ("f") {
        λ("x") { x ->
            x
        }
    }

val one =
    λ("f") { f ->
        λ("x") { x ->
            f _ x
        }
    }

val two =
    λ("f") { f ->
        λ("x") { x ->
            f _ (f _ x)
        }
    }

val three =
    λ("f") { f ->
        λ("x") { x ->
            f _ (f _ (f _ x))
        }
    }

val four =
    λ("f") { f ->
        λ("x") { x ->
            f _ (f _ (f _ (f _ x)))
        }
    }

val succ = λ("n") { n ->
    λ("f") { f ->
        λ("x") { x ->
            f _ (n _ f _ x)
        }
    }
}

val multiply =
    λ("a") { a ->
        λ("b") { b ->
            a _ (b _ succ) _ zero
        }
    }

val pow = λ("a") { a ->
    λ("b") { b ->
        λ("f") { f ->
            λ("x") { x ->
                b _ a _ f _ x
            }
        }
    }
}

val isZero = isFals3

val pred =
    λ("n") { n ->
        first _ (n _ pairStep _ (pairOf _ zero _ zero))
    }