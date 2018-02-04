import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion by project
val arrowVersion by extra { "0.6.1" }

plugins {
    kotlin("jvm") version "1.2.21"
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "1.8"

repositories {
    jcenter()
}

dependencies {
    compile(kotlin("stdlib", "$kotlinVersion"))
    compile(kotlin("stdlib-jdk7", "$kotlinVersion"))
    compile(kotlin("stdlib-jdk8", "$kotlinVersion"))
    compile(kotlin("reflect", "$kotlinVersion"))

    compile("io.arrow-kt:arrow-core:$arrowVersion")
    compile("io.arrow-kt:arrow-typeclasses:$arrowVersion")
    compile("io.arrow-kt:arrow-instances:$arrowVersion")
    compile("io.arrow-kt:arrow-effects:$arrowVersion")
    compile("io.arrow-kt:arrow-optics:$arrowVersion")
}

dependencies {
    testCompile(kotlin("test", "$kotlinVersion"))
    testCompile(kotlin("test-junit", "$kotlinVersion"))
}
