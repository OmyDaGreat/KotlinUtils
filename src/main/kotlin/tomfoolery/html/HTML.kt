package io.github.omydagreat.kotlinutils.tomfoolery.html

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import kotlinx.html.stream.createHTML

fun DIV.center(display: String = "flex", height: String = "100vh", fontSize: String = "16px", fontFamily: String = "Arial, sans-serif") {
    style = "display: $display; justify-content: center; align-items: center; height: $height; font-size: $fontSize; font-family: $fontFamily;"
}

fun generateHTMLContent(): String {
    return createHTML().html {
        body {
            div {
                center(fontSize = "20px", fontFamily = "Verdana, sans-serif")
                a("https://kotlinlang.org") {
                    target = ATarget.blank
                    +"Kotlin main site"
                }
            }
        }
    }
}

fun startServer() {
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                call.respondText(generateHTMLContent(), ContentType.Text.Html)
            }
        }
    }.start(wait = true)
}

fun main() {
    startServer()
}