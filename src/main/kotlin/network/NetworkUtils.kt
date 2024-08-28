package network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import java.net.InetSocketAddress
import java.net.Socket

/**
 * Configures the HttpClient to use JSON serialization with the ContentNegotiation plugin.
 *
 * @return A lambda function to configure the HttpClient.
 */
fun HttpClient.json() {
    config {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
}

/**
 * Checks if the internet connection is available.
 *
 * @return `true` if the internet connection is available, `false` otherwise.
 */
fun isInternetAvailable(): Boolean {
    return try {
        val socket = Socket()
        val socketAddress = InetSocketAddress("8.8.8.8", 53)
        socket.connect(socketAddress, 1500)
        socket.close()
        true
    } catch (e: Exception) {
        false
    }
}

/**
 * Makes a GET request to the specified URL.
 *
 * @param url The URL to make the GET request to.
 * @return The response body as a string.
 */
fun HttpClient.ezget(url: String): String = runBlocking {
    try {
        get(url).body<String>()
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}

/**
 * Makes a POST request to the specified URL with the given data.
 *
 * @param url The URL to make the POST request to.
 * @param data The data to be sent in the POST request.
 * @return The response body as a string.
 */
fun HttpClient.ezpost(url: String, data: String): String = runBlocking {
    try {
        post {
            url(url)
            contentType(ContentType.Application.Json)
            setBody(data)
        }.body<String>()
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}