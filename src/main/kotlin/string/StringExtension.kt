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
            word.substring(0, 1).uppercase(Locale.getDefault()) + word.substring(1).lowercase(Locale.getDefault())
        } else {
            word.lowercase(Locale.getDefault())
        }
    }.joinToString(" ")
}