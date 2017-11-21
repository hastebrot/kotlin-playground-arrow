import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion by project
val junitJupiterVersion by project
val junitPlatformVersion by project

plugins {
    kotlin("jvm") version "1.1.60"
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "1.8"

repositories {
    jcenter()
    maven("https://dl.bintray.com/kategory/maven")
}

dependencies {
    compile(kotlin("stdlib", "$kotlinVersion"))
    compile(kotlin("reflect", "$kotlinVersion"))
    compile(kotlin("stdlib-jre7", "$kotlinVersion"))

    val kategoryVersion = "0.3.11"
    compile("io.kategory:kategory:$kategoryVersion")
    compile("io.kategory:kategory-effects:$kategoryVersion")
    compile("io.kategory:kategory-optics:$kategoryVersion")
}

dependencies {
    testCompile(kotlin("test", "$kotlinVersion"))
    testCompile("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
    testRuntime("org.junit.platform:junit-platform-launcher:$junitPlatformVersion")
}
