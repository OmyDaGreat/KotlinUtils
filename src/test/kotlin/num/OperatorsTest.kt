package num

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertFailsWith

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
    assertThrows<IllegalArgumentException> { !-1 }
  }

  @Test
  fun maxOfTwoNumbers() {
    assertEquals(5, 3 max 5)
  }

  @Test
  fun minOfTwoNumbers() {
    assertEquals(3, 3 min 5)
  }

  @Test
  fun maxOfThreeNumbers() {
    assertEquals(5, 3 max 5 max 4)
  }

  @Test
  fun minOfThreeNumbers() {
    assertEquals(3, 3 min 5 min 4)
  }

  @Test
  fun powerOfNumber() {
    assertEquals(8, 2 pow 3)
  }

  @Test
  fun powerOfNumberWithDifferentTypes() {
    assertEquals(8L, 2L pow 3)
    assertEquals(8.0, 2.0 pow 3)
    assertEquals(8.0f, 2.0f pow 3)
  }

  @Test
  fun powerOfNumberWithUnsupportedTypeThrowsException() {
    assertFailsWith<IllegalArgumentException> { 2.toByte() pow 3 }
  }
}
