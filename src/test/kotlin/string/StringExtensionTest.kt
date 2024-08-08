package string

import io.github.omydagreat.kotlinutils.string.titlecase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringExtensionTest {

    @Test
    fun convertsEmptyStringToTitleCase() {
        assertEquals("", "".titlecase())
    }

    @Test
    fun convertsSingleWordToTitleCase() {
        assertEquals("Hello", "hello".titlecase())
    }

    @Test
    fun convertsMultipleWordsToTitleCase() {
        assertEquals("Hello World", "hello world".titlecase())
    }

    @Test
    fun doesNotCapitalizeWordsInSet() {
        assertEquals("The Quick Brown Fox Jumps Over the Lazy Dog", "the quick brown fox jumps over the lazy dog".titlecase())
    }

    @Test
    fun capitalizesFirstWordEvenIfInSet() {
        assertEquals("The Quick Brown Fox", "the quick brown fox".titlecase())
    }

    @Test
    fun handlesMixedCaseInput() {
        assertEquals("Hello World", "hElLo wOrLd".titlecase())
    }

    @Test
    fun handlesWordsWithMixedCaseInSet() {
        assertEquals("The Quick Brown Fox", "tHe qUiCk bRoWn fOx".titlecase())
    }

    @Test
    fun handlesWordsWithPunctuation() {
        assertEquals("Hello, World!", "hello, world!".titlecase())
    }

    @Test
    fun handlesWordsWithNumbers() {
        assertEquals("Hello 123 World", "hello 123 world".titlecase())
    }
}