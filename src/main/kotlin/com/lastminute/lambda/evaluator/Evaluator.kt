package com.lastminute.lambda.evaluator

import com.lastminute.lambda.LambdaExpression
import com.lastminute.lambda.LambdaExpression.*
import com.lastminute.lambda.rules.betaReduction

val zero =
    Abstraction("f",
        Abstraction("x",
            Variable("x")))

val three =
    Abstraction("f",
        Abstraction("x",
            Application(
                Variable("f"),
                Application(
                    Variable("f"),
                    Application(
                        Variable("f"),
                        Variable("x")
                    )
                )
            )
        )
    )

val four =
    Abstraction("f",
        Abstraction("x",
            Application(
                Variable("f"),
                Application(
                    Variable("f"),
                    Application(
                        Variable("f"),
                        Application(
                            Variable("f"),
                            Variable("x"))
                    )
                )
            )
        )
    )

val multiply =
    Abstraction("a",
        Abstraction("b",
            Application(
                Application(
                    Variable("a"),
                    Application(
                        Variable("b"),
                        Abstraction("n",
                            Abstraction("f",
                                Abstraction("x",
                                    Application(
                                        Application(
                                            Variable("n"),
                                            Variable("f")
                                        ),
                                        Application(
                                            Variable("f"),
                                            Variable("x")
                                        )
                                    )
                                )
                            )
                        )
                    )
                ),
                zero
            )
        )
    )

val program = Application(
    Application(
        multiply,
        three),
    four
)

tailrec fun reduce(lambdaExpression: LambdaExpression, stepAction: (LambdaExpression) -> Unit): LambdaExpression {
    val reductionResult = betaReduction(lambdaExpression)
    return if (reductionResult == lambdaExpression) {
        reductionResult
    } else {
        stepAction(reductionResult)
        reduce(reductionResult, stepAction)
    }
}

fun main(args: Array<String>) {

//    fun <In, Out> y(f: (_: (n: In) -> Out) -> (n: In) -> Out): (n: In) -> Out = { f(y(f))(it) }
//    val reduce = y<LambdaExpression, LambdaExpression> { f ->
//        {
//            val reductionResult = betaReduction(it)
//            if (reductionResult == it) {
//                reductionResult
//            } else {
//                f(reductionResult)
//            }
//        }
//    }

    println(reduce(program) { println("= $it") })
}