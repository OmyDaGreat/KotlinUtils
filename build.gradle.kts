plugins { kotlin("jvm") version "2.0.0" }

group = "io.github.omydagreat.kotlinutils"

version = "0.1"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

val kmlogVersion = "1.5.0"
val slf4jVersion = "2.0.13"
val coroutinesVersion = "1.9.0-RC"
val kotlinxhtmlVersion = "0.11.0"
val ktorVersion = "2.3.12"

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.lighthousegames:logging:$kmlogVersion")
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:$kotlinxhtmlVersion")
    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-html-builder-jvm:$ktorVersion")
}

tasks.test { useJUnitPlatform() }

kotlin { jvmToolchain(21) }
