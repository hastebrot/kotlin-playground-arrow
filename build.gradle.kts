import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.Coroutines

val gradleWrapperVersion: String by project
val kotlinVersion: String by project
val arrowVersion by extra { "0.7.2" }

plugins {
    val kotlinVersion = "1.2.50"
    val dokkaVersion = "0.9.17"

    kotlin("jvm") version kotlinVersion
    id("org.jetbrains.dokka") version dokkaVersion
}

repositories {
    jcenter()
}

dependencies {
    compile(kotlin("stdlib", kotlinVersion))
    compile(kotlin("stdlib-jdk7", kotlinVersion))
    compile(kotlin("stdlib-jdk8", kotlinVersion))
    compile(kotlin("reflect", kotlinVersion))

    compile("io.arrow-kt:arrow-core:$arrowVersion")
    compile("io.arrow-kt:arrow-syntax:$arrowVersion")
    compile("io.arrow-kt:arrow-typeclasses:$arrowVersion")
    compile("io.arrow-kt:arrow-data:$arrowVersion")
    compile("io.arrow-kt:arrow-instances-core:$arrowVersion")
    compile("io.arrow-kt:arrow-instances-data:$arrowVersion")
    compile("io.arrow-kt:arrow-effects:$arrowVersion")
    compile("io.arrow-kt:arrow-optics:$arrowVersion")
//    compile("io.arrow-kt:arrow-recursion:$arrowVersion")
}

dependencies {
    testCompile(kotlin("test", kotlinVersion))
    testCompile(kotlin("test-junit5", kotlinVersion))
}

//java {
//    sourceCompatibility = JavaVersion.VERSION_1_8
//    targetCompatibility = JavaVersion.VERSION_1_8
//}

kotlin {
    experimental.coroutines = Coroutines.ENABLE
}

tasks {
    withType<Wrapper> {
        gradleVersion = gradleWrapperVersion
        distributionType = Wrapper.DistributionType.ALL
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    withType<DokkaTask> {
        outputFormat = "javadoc"
        outputDirectory = "$buildDir/javadoc"
    }

    "dokkaJavadoc"(DokkaTask::class) {
        outputFormat = "javadoc"
        outputDirectory = "$buildDir/javadoc"
    }
}
