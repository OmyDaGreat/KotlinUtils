package num

import kotlin.math.pow

/**
 * Computes the factorial of a non-negative integer.
 *
 * @return The factorial of the integer.
 * @receiver The integer for which the factorial is to be computed. Must be non-negative.
 * @throws IllegalArgumentException if the integer is negative.
 */
operator fun Int.not(): Int {
  require(this >= 0) { "Factorial is not defined for negative numbers" }

  tailrec fun tailrecHelper(n: Int, acc: Int): Int {
    return if (n <= 1) acc else tailrecHelper(n - 1, n * acc)
  }

  return tailrecHelper(this, 1)
}

/**
 * Returns the maximum of two comparable values.
 *
 * @param T The type of the values, which must implement the Comparable interface.
 * @param other The second value to compare.
 * @return The maximum of the two values.
 * @receiver The first value to compare.
 */
infix fun <T : Comparable<T>> T.max(other: T): T = if (this > other) this else other

/**
 * Returns the minimum of two comparable values.
 *
 * @param T The type of the values, which must implement the Comparable interface.
 * @param other The second value to compare.
 * @return The minimum of the two values.
 * @receiver The first value to compare.
 */
infix fun <T : Comparable<T>> T.min(other: T): T = if (this < other) this else other

/**
 * Computes the power of a number.
 *
 * @param T The type of the number, which must implement the Number interface.
 * @param exponent The exponent to which the number is to be raised.
 * @return The result of raising the number to the given exponent.
 * @receiver The base number to be raised to the power of the exponent.
 * @throws IllegalArgumentException if the type is unsupported.
 */
inline infix fun <reified T : Number> T.pow(exponent: Int) =
  typeReturn<T>(this.toDouble().pow(exponent))

/**
 * Converts the result of a power calculation to the appropriate type.
 *
 * @param T The type of the number, which must implement the Number interface.
 * @param result The result of the power calculation as a Double.
 * @return The result of the power calculation converted to the appropriate type.
 * @throws IllegalArgumentException if the type is unsupported.
 */
inline fun <reified T : Number> typeReturn(result: Double) =
  when (T::class) {
    Int::class -> result.toInt() as T
    Long::class -> result.toLong() as T
    Float::class -> result.toFloat() as T
    Double::class -> result as T
    else -> throw IllegalArgumentException("Unsupported type")
  }
