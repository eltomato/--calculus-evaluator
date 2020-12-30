package com.eltomato.lambda.terms

import com.eltomato.lambda.LambdaExpression
import com.eltomato.lambda.LambdaExpression.Variable
import com.eltomato.lambda.`_`
import com.eltomato.lambda.rules.reduce
import org.junit.Assert.assertThat
import org.junit.Test
import org.hamcrest.core.Is.`is` as isSameAs

class NumeralsTest {

    @Test
    fun succZero() {
        val result = succ _ zero
        assertThat(reduce(result), isSameAs(one))
    }

    @Test
    fun succOne() {
        val result = succ _ one
        assertThat(reduce(result), isSameAs(two))
    }

    @Test
    fun succTwo() {
        val result = succ _ two
        assertThat(reduce(result), isSameAs(three))
    }

    @Test
    fun succThree() {
        val result = succ _ three
        assertThat(reduce(result), isSameAs(four))
    }

    @Test
    fun succFour() {
        val result = succ _ four
        assertThat(reduce(result), isSameAs(five))
    }

    @Test
    fun succFive() {
        val result = succ _ five
        assertThat(reduce(result), isSameAs(six))
    }

    @Test
    fun zeroTimesOne() {
        val result = multiply _ zero _ one
        assertThat(reduce(result), isSameAs(zero))
    }

    @Test
    fun oneTimeZero() {
        val result = multiply _ one _ zero
        assertThat(reduce(result), isSameAs(zero))
    }

    @Test
    fun twoTimesOne() {
        val result = multiply _ two _ one
        assertThat(reduce(result), isSameAs(two))
    }

    @Test
    fun threeTimesTwo() {
        val result = multiply _ three _ two
        assertThat(reduce(result), isSameAs(six))
    }

    @Test
    fun twoTimesThree() {
        val result = multiply _ two _ three
        assertThat(reduce(result), isSameAs(six))
    }

    @Test
    fun twoTimesSix() {
        val result = multiply _ two _ six
        assertThat(reduce(result), isSameAs(twelve))
    }

    @Test
    fun threeTimesFour() {
        val result = multiply _ three _ four
        assertThat(reduce(result), isSameAs(twelve))
    }

    @Test
    fun predOne() {
        val result = pred _ one
        assertThat(reduce(result), isSameAs(zero))
    }

    @Test
    fun predZero() {
        val result = pred _ zero
        assertThat(reduce(result), isSameAs(zero))
    }

    @Test
    fun predTwo() {
        val result = pred _ two
        assertThat(reduce(result), isSameAs(one))
    }

    @Test
    fun predThree() {
        val result = pred _ three
        assertThat(reduce(result), isSameAs(two))
    }

    @Test
    fun predFour() {
        val result = pred _ four
        assertThat(reduce(result), isSameAs(three))
    }

    @Test
    fun isZero() {
        assertThat(reduce(isZero _ zero), isSameAs(tru3))
        assertThat(reduce(isZero _ one), isSameAs(fals3))
        assertThat(reduce(isZero _ two), isSameAs(fals3))
        assertThat(reduce(isZero _ four), isSameAs(fals3))
        assertThat(reduce(isZero _ five), isSameAs(fals3))
        assertThat(reduce(isZero _ six), isSameAs(fals3))
        assertThat(reduce(isZero _ twelve), isSameAs(fals3))
    }
}