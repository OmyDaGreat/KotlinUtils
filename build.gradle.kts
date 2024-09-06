plugins {
  kotlin("multiplatform") version "2.0.0"
  `maven-publish`
}

group = "io.github.omydagreat"
version = "1.1.4"

repositories {
  mavenCentral()
  maven { url = uri("https://jitpack.io") }
}

val kermitV = "2.0.4"

kotlin {
  jvm()
  js(IR) {
    browser()
    nodejs()
  }
  linuxX64()
  macosX64()
  macosArm64()

  sourceSets {
    val commonMain by getting {
      kotlin.srcDirs("src/common/commonMain/kotlin")
      dependencies {
        implementation("co.touchlab:kermit:$kermitV")
      }
    }
    val commonTest by getting {
      kotlin.srcDirs("src/common/commonTest/kotlin")
      dependencies {
        implementation(kotlin("test"))
      }
    }
    val jvmMain by getting
    val jvmTest by getting
    val jsMain by getting
    val jsTest by getting
    val linuxX64Main by getting
    val linuxX64Test by getting
    val macosX64Main by getting
    val macosX64Test by getting
    val macosArm64Main by getting
    val macosArm64Test by getting
  }
}

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
      from(components["kotlin"])
      groupId = "io.github.omydagreat"
      artifactId = "kotlinutils"
      version = project.version.toString()
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
