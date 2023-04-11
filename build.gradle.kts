import com.chrynan.presentation.buildSrc.LibraryConstants

group = LibraryConstants.group
version = LibraryConstants.versionName

buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
        maven { url = uri("https://repo.repsy.io/mvn/chrynan/public") }
    }
    dependencies {
        classpath("org.jetbrains.compose:compose-gradle-plugin:1.4.0-rc03")
    }
}

plugins {
    kotlin("jvm") version "1.8.10" apply false
    kotlin("multiplatform") version "1.8.10" apply false
    kotlin("android") version "1.8.10" apply false
    kotlin("plugin.serialization") version "1.8.10" apply false
    id("com.android.library") version "7.3.1" apply false
    id("com.android.application") version "7.3.1" apply false
    id("org.jetbrains.dokka") version "1.8.10"
    id("com.vanniktech.dependency.graph.generator") version "0.7.0"
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://repo.repsy.io/mvn/chrynan/public") }
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    }
}

// Documentation
tasks.named<org.jetbrains.dokka.gradle.DokkaMultiModuleTask>("dokkaGfmMultiModule").configure {
    outputDirectory.set(file("${projectDir.path}/docs"))
}
