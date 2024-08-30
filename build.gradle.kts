plugins {
    kotlin("jvm") version "2.0.0"
    `java-library`
    `maven-publish`
}

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
val serialVerison = "1.7.1"

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.lighthousegames:logging:$kmlogVersion")
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serialVerison")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
}

tasks.test { useJUnitPlatform() }

kotlin { jvmToolchain(21) }

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/OmyDaGreat/KotlinUtils")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}