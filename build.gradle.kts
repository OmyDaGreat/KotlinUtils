plugins {
  kotlin("jvm") version "2.0.0"
  `maven-publish`
  id("ca.cutterslade.analyze") version "1.10.0"
}

group = "io.github.omydagreat.kotlinutils"
version = "1.1.1"

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
}

tasks.test { useJUnitPlatform() }

kotlin { jvmToolchain(21) }

publishing {
  repositories {
    maven {
      name = "KotlinUtils"
      url = uri("https://maven.pkg.github.com/omydagreat/kotlinutils")
      credentials {
        username = System.getenv("USERNAME") ?: "OmyDaGreat"
        password = System.getenv("GITHUB_TOKEN")
      }
    }
  }
  publications {
    register<MavenPublication>("gpr") {
      groupId = "io.github.omydagreat"
      artifactId = "kotlinutils"
      version = project.version.toString()
      from(components["java"])
      pom {
        name.set(project.name)
        description.set("A utility library for Kotlin")
        url.set("https://github.com/OmyDaGreat/KotlinUtils")

        licenses {
          license {
            name.set("MIT License")
            url.set("https://opensource.org/licenses/MIT")
          }
        }

        scm {
          connection.set("scm:git:git://github.com/OmyDaGreat/KotlinUtils.git")
          developerConnection.set("scm:git:ssh://git@github.com:OmyDaGreat/KotlinUtils.git")
          url.set("https://github.com/OmyDaGreat/KotlinUtils")
        }
      }
    }
  }
}
