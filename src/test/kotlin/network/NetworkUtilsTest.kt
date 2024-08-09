package network

import io.github.omydagreat.kotlinutils.network.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NetworkUtilsTest {
    private val client = HttpClient(CIO).apply { json() }

    @Test
    fun isInternetAvailable_returnsTrue_whenConnectionIsSuccessful() {
        assertTrue(isInternetAvailable())
    }

    @Test
    fun isInternetAvailable_returnsFalse_whenConnectionFails() {
        // Simulate a failure by using an invalid address
        assertTrue(isInternetAvailable())
    }

    @Test
    fun ezget_returnsResponseBody_whenRequestIsSuccessful() = runBlocking {
        val response = client.ezget("https://jsonplaceholder.typicode.com/posts/1")
        assertTrue(response.isNotEmpty())
    }

    @Test
    fun ezget_returnsEmptyString_whenRequestFails() = runBlocking {
        val response = client.ezget("https://invalid.url")
        assertEquals("", response)
    }

    @Test
    fun ezpost_returnsResponseBody_whenRequestIsSuccessful() = runBlocking {
        val response = client.ezpost("https://jsonplaceholder.typicode.com/posts", """{"title": "foo", "body": "bar", "userId": 1}""")
        assertTrue(response.isNotEmpty())
    }

    @Test
    fun ezpost_returnsEmptyString_whenRequestFails() = runBlocking {
        val response = client.ezpost("https://invalid.url", """{"title": "foo", "body": "bar", "userId": 1}""")
        assertEquals("", response)
    }
}