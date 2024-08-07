plugins {
    kotlin("jvm") version "2.0.0"
}

group = "io.github.omydagreat.kotlinutils"
version = "1.0"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

val kmlogVersion = "1.5.0"
val slf4jVersion = "2.0.13"

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.lighthousegames:logging:$kmlogVersion")
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}