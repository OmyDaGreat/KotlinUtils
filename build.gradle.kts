plugins {
    kotlin("jvm") version "2.0.0"
}

group = "io.github.omydagreat.kotlinutils"
version = "1.0"

repositories {
    mavenCentral()
}

val kotlinVersion = "2.0.0"
val kotlinLoggerVersion = "7.0.0"
val slf4jVersion = "2.0.13"
val log4jVersion = "2.23.1"

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.github.oshai:kotlin-logging:$kotlinLoggerVersion")
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}