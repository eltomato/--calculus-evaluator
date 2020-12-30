package com.eltomato.lambda.terms

import com.eltomato.lambda.`_`
import com.eltomato.lambda.λ

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

val five =
        λ("f") { f ->
            λ("x") { x ->
                f _ (f _ (f _ (f _ (f _ x))))
            }
        }

val six =
        λ("f") { f ->
            λ("x") { x ->
                f _ (f _ (f _ (f _ (f _ (f _ x)))))
            }
        }

val twelve =
        λ("f") { f ->
            λ("x") { x ->
                f _ (f _ (f _ (f _ (f _ (f _ (f _ (f _ (f _ (f _ (f _ (f _ x)))))))))))
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

private val pairStep =
        λ("pair") { pair ->
            pairOf _ (second _ pair) _ (succ _ (second _ pair))
        }

val pred =
        λ("n") { n ->
            first _ (n _ pairStep _ (pairOf _ zero _ zero))
        }