package com.eltomato.lambda.terms

import com.eltomato.lambda.LambdaExpression
import com.eltomato.lambda.LambdaExpression.Variable
import com.eltomato.lambda.`_`
import com.eltomato.lambda.rules.reduce
import org.junit.Assert.assertThat
import org.junit.Test
import org.hamcrest.core.Is.`is` as isSameAs

class BooleansTest {

    @Test
    fun eefTrue() {
        val statement = eef _ tru3 _ Variable("first") _ Variable("second")
        assertThat(reduce(statement, {}), isSameAs(Variable("first") as LambdaExpression))
    }

    @Test
    fun eefFalse() {
        val statement = eef _ fals3 _ Variable("first") _ Variable("second")
        assertThat(reduce(statement, {}), isSameAs(Variable("second") as LambdaExpression))
    }
}