package com.eltomato.lambda.terms

import com.eltomato.lambda.LambdaExpression
import com.eltomato.lambda.LambdaExpression.Variable
import com.eltomato.lambda.`_`
import com.eltomato.lambda.rules.reduce
import org.junit.Assert.assertThat
import org.junit.Test
import org.hamcrest.core.Is.`is` as isSameAs

class PairsTest {

    @Test
    fun takeFirst() {
        val pair = pairOf _ Variable("first") _ Variable("second")
        val first = first _ pair
        assertThat(reduce(first, {}), isSameAs(Variable("first") as LambdaExpression))
    }

    @Test
    fun takeSecond() {
        val pair = pairOf _ Variable("first") _ Variable("second")
        val second = second _ pair
        assertThat(reduce(second, {}), isSameAs(Variable("second") as LambdaExpression))
    }
}