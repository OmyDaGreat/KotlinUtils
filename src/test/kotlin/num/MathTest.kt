package num

import io.github.omydagreat.kotlinutils.num.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.assertFailsWith

class MathTest {

    @Test
    fun factorial_returnsCorrectValue_forPositiveNumbers() {
        assertEquals(120, factorial(5))
    }

    @Test
    fun factorial_returnsOne_forZero() {
        assertEquals(1, factorial(0))
    }

    @Test
    fun factorial_throwsException_forNegativeNumbers() {
        assertFailsWith<IllegalArgumentException> { factorial(-1) }
    }

    @Test
    fun trinum_returnsCorrectValue_forPositiveNumbers() {
        assertEquals(15, trinum(5))
    }

    @Test
    fun trinum_returnsOne_forZero() {
        assertEquals(0, trinum(0))
    }

    @Test
    fun trinum_throwsException_forNegativeNumbers() {
        assertFailsWith<IllegalArgumentException> { trinum(-1) }
    }

    @Test
    fun isPrime_returnsTrue_forPrimeNumbers() {
        assertTrue(isPrime(7))
    }

    @Test
    fun isPrime_returnsFalse_forNonPrimeNumbers() {
        assertFalse(isPrime(4))
    }

    @Test
    fun isPrime_returnsFalse_forNumbersLessThanTwo() {
        assertFalse(isPrime(1))
    }

    @Test
    fun gcd_returnsCorrectValue_forPositiveNumbers() {
        assertEquals(6, gcd(54, 24))
    }

    @Test
    fun gcd_returnsFirstNumber_whenSecondNumberIsZero() {
        assertEquals(54, gcd(54, 0))
    }

    @Test
    fun generateFibonacci_returnsCorrectSequence_forPositiveCount() {
        assertEquals(listOf(0L, 1L, 1L, 2L, 3L, 5L, 8L), generateFibonacci(7))
    }

    @Test
    fun generateFibonacci_returnsEmptyList_forZeroCount() {
        assertEquals(emptyList(), generateFibonacci(0))
    }

    @Test
    fun generateFibonacci_throwsException_forNegativeCount() {
        assertFailsWith<IllegalArgumentException> { generateFibonacci(-1) }
    }

    @Test
    fun cToF_returnsCorrectValue_forPositiveCelsius() {
        assertEquals(32.0, cToF(0.0))
    }

    @Test
    fun fToC_returnsCorrectValue_forPositiveFahrenheit() {
        assertEquals(0.0, fToC(32.0))
    }
}