package com.eltomato.lambda.evaluator

import com.eltomato.lambda.`_`
import com.eltomato.lambda.rules.reduce
import com.eltomato.lambda.terms.Y
import com.eltomato.lambda.terms.fact
import com.eltomato.lambda.terms.three

fun main() {

    val program = Y _ fact _ three

    println(program)
    println(reduce(program) { println("= $it") })
}