pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = uri("https://repo.repsy.io/mvn/chrynan/public") }
    }
}

plugins {
    // See https://jmfayard.github.io/refreshVersions
    id("de.fayard.refreshVersions") version "0.51.0"
////                            # available:"0.60.0"
////                            # available:"0.60.1"
////                            # available:"0.60.2"
////                            # available:"0.60.3"
////                            # available:"0.60.4"
////                            # available:"0.60.5"

    // See build.gradle.kts file in root project folder for the rest of the plugins applied.
}

rootProject.name = "cycle"

include(":cycle-core")
include(":cycle-compose")
