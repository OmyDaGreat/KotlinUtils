package io.github.omydagreat.kotlinutils

import io.github.oshai.kotlinlogging.KotlinLogging

private val logger = KotlinLogging.logger {}

private const val message = "world"
fun main() {
    logger.debug { "hello $message" }
}