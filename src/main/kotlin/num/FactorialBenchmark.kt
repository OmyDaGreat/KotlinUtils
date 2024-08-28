package num

import kotlin.system.measureNanoTime

fun main() {
    val n = 20

    val nonTailRecTime = measureNanoTime {
        println("Factorial of $n using non-tail-recursive version: ${factorialNonTailRec(n)}")
    }
    println("Time taken by non-tail-recursive version: $nonTailRecTime ms")

    val tailRecTime = measureNanoTime {
        println("Factorial of $n using tail-recursive version: ${factorialTailRec(n)}")
    }
    println("Time taken by tail-recursive version: $tailRecTime ms")
}

// Non-tail-recursive version
fun factorialNonTailRec(n: Int): Int {
    require(n >= 0) { "Factorial is not defined for negative numbers" }
    return if (n == 0 || n == 1) 1 else n * factorialNonTailRec(n - 1)
}

// Tail-recursive version
fun factorialTailRec(n: Int): Int {
    require(n >= 0) { "Factorial is not defined for negative numbers" }

    tailrec fun factorialTailRecHelper(n: Int, acc: Int): Int {
        return if (n <= 1) acc else factorialTailRecHelper(n - 1, n * acc)
    }

    return factorialTailRecHelper(n, 1)
}