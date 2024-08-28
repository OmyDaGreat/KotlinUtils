package num

operator fun Int.not(): Int {
  require(this >= 0) { "Factorial is not defined for negative numbers" }

  tailrec fun factorialTailRecHelper(n: Int, acc: Int): Int {
    return if (n <= 1) acc else factorialTailRecHelper(n - 1, n * acc)
  }

  return factorialTailRecHelper(this, 1)
}
