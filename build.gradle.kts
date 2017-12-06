import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion by project
val junitJupiterVersion by project
val junitPlatformVersion by project
val kategoryVersion by extra { "0.3.11" }

plugins {
    kotlin("jvm") version "1.2.0"
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "1.8"

repositories {
    jcenter()
    maven("https://dl.bintray.com/kategory/maven")
}

dependencies {
    compile(kotlin("stdlib", "$kotlinVersion"))
    compile(kotlin("stdlib-jdk7", "$kotlinVersion"))
    compile(kotlin("stdlib-jdk8", "$kotlinVersion"))
    compile(kotlin("reflect", "$kotlinVersion"))

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
