package io.github.omydagreat.kotlinutils.tomfoolery.html

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import kotlinx.html.stream.createHTML

var bool = true

fun DIV.center(
    display: String = "flex",
    flexDirection: String = "column",
    height: String = "100vh",
    fontSize: String = "16px",
    fontFamily: String = "Arial, sans-serif"
) {
    style =
        "display: $display; flex-direction: $flexDirection; justify-content: center; align-items: center; height: $height; font-size: $fontSize; font-family: $fontFamily;"
}

fun generateHTMLContent(boolValue: Boolean): String =
    createHTML().html {
        head {
            js(
                """
                // noinspection JSUnusedLocalSymbols
                function changeBool() {
                    fetch('/changeBool', { method: 'POST' })
                        .then(response => response.text())
                        .then(() => location.reload());
                }
                """
                    .trimIndent())
        }
        body {
            div {
                center(fontSize = "20px", fontFamily = "Verdana, sans-serif")
                p { +"bool: $boolValue" }
                button {
                    onClick = "changeBool()"
                    +"Run Kotlin Function"
                }
            }
        }
    }

private fun HEAD.js(script: String) {
    script { unsafe { +script } }
}

fun server() =
    embeddedServer(Netty, port = 82) {
        routing {
            get("/") { call.respondText(generateHTMLContent(bool), ContentType.Text.Html) }
            post("/changeBool") {
                bool = !bool
                call.respondText("Boolean value changed!", ContentType.Text.Plain)
            }
        }
    }

fun main() {
    server().start(wait = true)
}
