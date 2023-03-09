plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "pacman.demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.palex65:CanvasLib-jvm:1.0.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("pacman.MainKt")
}