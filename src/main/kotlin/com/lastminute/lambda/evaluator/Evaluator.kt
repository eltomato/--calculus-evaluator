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

fun main(args: Array<String>) {

    var multiplication: LambdaExpression = program

    for (i in 0..50) {
        println("= $multiplication")
        multiplication = betaReduction(multiplication)
    }
}