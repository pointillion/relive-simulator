val project_version: String by project
val api_version: String by project

plugins {
  kotlin("multiplatform")
  id("org.jetbrains.kotlin.plugin.serialization") version "1.7.10"
  id("com.peterabeles.gversion")
}

group = "xyz.qwewqa.relive.simulator"

version = project_version

gversion {
  srcDir = "src/commonMain/kotlin"
  classPackage = "xyz.qwewqa.relive.simulator.common"
  language = "kotlin"
  indent = "  "
}

repositories { mavenCentral() }

kotlin {
  jvm { testRuns["test"].executionTask.configure { useJUnitPlatform() } }
  js(IR) {
    browser()
    compilations.all {
      kotlinOptions {
        freeCompilerArgs +=
            listOf("-Xir-property-lazy-initialization", "-Xir-minimized-member-names=false")
      }
    }
  }
  sourceSets.all { languageSettings { optIn("kotlin.RequiresOptIn") } }
}

dependencies {
  "commonMainImplementation"(kotlin("stdlib"))
  "commonMainImplementation"("com.github.h0tk3y.betterParse:better-parse:0.4.4")
  "commonMainImplementation"("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
  "commonMainImplementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
  "commonTestImplementation"(kotlin("test"))
  "commonTestImplementation"("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
}

task("generateApiVersionFile") {
  doLast {
    file("$projectDir/src/commonMain/kotlin/xyz/qwewqa/relive/simulator/common/ApiVersion.kt")
        .writeText(
            """
            package xyz.qwewqa.relive.simulator.common
            
            internal const val API_VERSION = $api_version
        """
                .trimIndent())
  }
}

tasks.withType(org.jetbrains.kotlin.gradle.dsl.KotlinCompile::class) {
  dependsOn("generateApiVersionFile")
  dependsOn("createVersionFile")
}
