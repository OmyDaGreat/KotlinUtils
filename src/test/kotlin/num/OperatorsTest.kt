package num

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OperatorsTest {

  @Test
  fun factorialOfZeroIsOne() {
    assertEquals(1, !0)
  }

  @Test
  fun factorialOfOneIsOne() {
    assertEquals(1, !1)
  }

  @Test
  fun factorialOfThree() {
    assertEquals(6, !3)
  }

  @Test
  fun factorialOfFour() {
    assertEquals(24, !4)
  }

  @Test
  fun factorialOfFive() {
    assertEquals(120, !5)
  }

  @Test
  fun factorialOfNegativeNumberThrowsException() {
    assertThrows<IllegalArgumentException> {
      !-1
    }
  }
}