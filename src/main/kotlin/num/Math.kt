package io.github.omydagreat.kotlinutils.num

import kotlin.math.sqrt

/**
 * Function to calculate the factorial of a number.
 *
 * @param n The number to calculate the factorial of.
 * @return The factorial of the number.
 */
fun factorial(n: Int): Long {
    require(n >= 0) { "Factorial is not defined for negative numbers" }
    return if (n == 0) 1 else n * factorial(n - 1)
}

/**
 * Function to calculate the triangular value of a number.
 *
 * @param n The number to calculate the triangular value of.
 * @return The triangular value of the number.
 */
fun trinum(n: Int): Long {
    require(n >= 0) { "Triangular value is not defined for negative numbers" }
    return if (n == 0) 0 else n + trinum(n - 1)
}


/**
 * Function to check if a number is prime.
 *
 * @param n The number to check.
 * @return `true` if the number is prime, `false` otherwise.
 */
fun isPrime(n: Int): Boolean {
    if (n <= 1) return false
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) return false
    }
    return true
}

/**
 * Function to find the greatest common divisor (GCD) of two numbers.
 *
 * @param a The first number.
 * @param b The second number.
 * @return The GCD of the two numbers.
 */
fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

/**
 * Function to generate a list of Fibonacci numbers up to a given count.
 *
 * @param count The number of Fibonacci numbers to generate.
 * @return A list of Fibonacci numbers.
 */
fun generateFibonacci(count: Int): List<Long> {
    require(count >= 0) { "Count must be non-negative" }
    val fibonacciList = mutableListOf<Long>()
    var a = 0L
    var b = 1L
    for (i in 0 until count) {
        fibonacciList.add(a)
        val temp = a
        a = b
        b += temp
    }
    return fibonacciList
}

/**
 * Function to convert a temperature from Celsius to Fahrenheit.
 *
 * @param celsius The temperature in Celsius.
 * @return The temperature in Fahrenheit.
 */
fun cToF(celsius: Double): Double = celsius * 9 / 5 + 32

/**
 * Function to convert a temperature from Fahrenheit to Celsius.
 *
 * @param fahrenheit The temperature in Fahrenheit.
 * @return The temperature in Celsius.
 */
fun fToC(fahrenheit: Double): Double = (fahrenheit - 32) * 5 / 9