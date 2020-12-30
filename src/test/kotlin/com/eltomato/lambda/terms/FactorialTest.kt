package com.eltomato.lambda.terms

import com.eltomato.lambda.LambdaExpression
import com.eltomato.lambda.LambdaExpression.Variable
import com.eltomato.lambda.`_`
import com.eltomato.lambda.rules.reduce
import org.junit.Assert.assertThat
import org.junit.Test
import org.hamcrest.core.Is.`is` as isSameAs

class FactorialTest {

    @Test
    fun zeroFactorial() {
        val statement = fact _ zero
        assertThat(reduce(statement), isSameAs(one))
    }

    @Test
    fun oneFactorial() {
        val statement = fact _ one
        assertThat(reduce(statement), isSameAs(one))
    }

    @Test
    fun twoFactorial() {
        val statement = fact _ two
        assertThat(reduce(statement), isSameAs(two))
    }

    @Test
    fun threeFactorial() {
        val statement = fact _ three
        assertThat(reduce(statement), isSameAs(six))
    }

    @Test
    fun fourFactorial() {
        val statement = fact _ four
        println(statement)
        println(Y)
        assertThat(reduce(statement), isSameAs(reduce(multiply _ twelve _ two)))
    }
}