package bool

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BoolHandlingTest {

  @Test
  fun run_executesTrueFunction_whenBooleanIsTrue() {
    var executed = false
    true.run(t = { executed = true })
    assertEquals(true, executed)
  }

  @Test
  fun run_executesFalseFunction_whenBooleanIsFalse() {
    var executed = false
    false.run(f = { executed = true })
    assertEquals(true, executed)
  }

  @Test
  fun run_returnsBooleanValue() {
    assertEquals(true, true.run())
    assertEquals(false, false.run())
  }

  @Test
  fun runT_executesTrueFunction_whenBooleanIsTrue() {
    var executed = false
    true.runT(t = { executed = true })
    assertEquals(true, executed)
  }

  @Test
  fun runT_doesNotExecuteTrueFunction_whenBooleanIsFalse() {
    var executed = false
    false.runT(t = { executed = true })
    assertEquals(false, executed)
  }

  @Test
  fun runT_returnsBooleanValue() {
    assertEquals(true, true.runT())
    assertEquals(false, false.runT())
  }

  @Test
  fun runF_executesFalseFunction_whenBooleanIsFalse() {
    var executed = false
    false.runF(f = { executed = true })
    assertEquals(true, executed)
  }

  @Test
  fun runF_doesNotExecuteFalseFunction_whenBooleanIsTrue() {
    var executed = false
    true.runF(f = { executed = true })
    assertEquals(false, executed)
  }

  @Test
  fun runF_returnsBooleanValue() {
    assertEquals(true, true.runF())
    assertEquals(false, false.runF())
  }
}
