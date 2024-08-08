package io.github.omydagreat.kotlinutils.string

import java.util.*

/**
 * A set of words that should not be capitalized in the title case.
 */
private val WORDS_NOT_TO_CAPITALIZE = setOf(
    "a", "an", "the", "and", "but", "or", "for", "nor", "on", "at", "to", "from", "by", "in", "of"
)

/**
 * Extension function to convert a string to title case.
 *
 * Words in the `WORDS_NOT_TO_CAPITALIZE` set will remain in lowercase unless they are the first word.
 *
 * @receiver The string to be converted to title case.
 * @return The string in title case.
 */
fun String.titlecase(): String {
    if (isEmpty()) return this

    return split(" ").mapIndexed { index, word ->
        if (index == 0 || !WORDS_NOT_TO_CAPITALIZE.contains(word.lowercase(Locale.getDefault()))) {
            word.substring(0, 1).uppercase() + word.substring(1).lowercase()
        } else {
            word.lowercase()
        }
    }.joinToString(" ")
}

/**
 * Extension function to check if a string is a valid email address.
 *
 * @receiver The string to be checked.
 * @return `true` if the string matches the email pattern, `false` otherwise.
 */
fun String.isEmail(): Boolean {
    return matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex())
}

/**
 * Extension function to check if a string is numeric.
 *
 * @receiver The string to be checked.
 * @return `true` if the string contains only digits, `false` otherwise.
 */
fun String.isNumeric(): Boolean {
    return matches("\\d+".toRegex())
}

/**
 * Extension function to capitalize the first letter of a string.
 *
 * @receiver The string to be modified.
 * @return The string with the first letter capitalized.
 */
fun String.capitalizeFirstLetter(): String {
    if (isNullOrEmpty()) {
        return this
    }
    return this[0].uppercaseChar().toString() + substring(1)
}

/**
 * Extension function to convert a string with spaces to camel case.
 *
 * @receiver The string to be converted.
 * @return The string in camel case.
 */
fun String.toCamelCase(): String {
    if (isNullOrEmpty()) {
        return this
    }
    val words = split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val camelCaseString = StringBuilder()
    for (word in words) {
        camelCaseString.append(word.lowercase().capitalizeFirstLetter())
    }
    return camelCaseString.toString()
}