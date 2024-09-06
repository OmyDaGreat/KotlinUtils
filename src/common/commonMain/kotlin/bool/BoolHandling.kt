package bool

@Deprecated("I would suggest chaining the runT and runF infixes. This may be removed soon.")
/**
 * Executes one of two functions based on the Boolean value.
 *
 * @param t The function to execute if the Boolean value is true. Defaults to an empty function.
 * @param f The function to execute if the Boolean value is false. Defaults to an empty function.
 * @return The Boolean value itself.
 */
fun Boolean.run(t: () -> Unit = {}, f: () -> Unit = {}): Boolean {
  if (this) {
    t()
  } else {
    f()
  }
  return this
}

/**
 * Executes a function if the Boolean value is true.
 *
 * @param t The function to execute if the Boolean value is true. Defaults to an empty function.
 * @return The Boolean value itself.
 */
infix fun Boolean.runT(t: () -> Unit): Boolean {
  if (this) {
    t()
  }
  return this
}

/**
 * Executes a function if the Boolean value is false.
 *
 * @param f The function to execute if the Boolean value is false. Defaults to an empty function.
 * @return The Boolean value itself.
 */
infix fun Boolean.runF(f: () -> Unit): Boolean {
  if (!this) {
    f()
  }
  return this
}
