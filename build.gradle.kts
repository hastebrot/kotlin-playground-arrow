import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val gradleWrapperVersion: String by project
val kotlinVersion: String by project
val arrowVersion by extra { "0.7.2" }

plugins {
    val kotlinVersion = "1.3.72"
    val dokkaVersion = "0.10.1"

    kotlin("jvm") version kotlinVersion
    id("org.jetbrains.dokka") version dokkaVersion
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib", kotlinVersion))
    implementation(kotlin("stdlib-jdk7", kotlinVersion))
    implementation(kotlin("stdlib-jdk8", kotlinVersion))
    implementation(kotlin("reflect", kotlinVersion))

    implementation("io.arrow-kt:arrow-core:$arrowVersion")
    implementation("io.arrow-kt:arrow-syntax:$arrowVersion")
    implementation("io.arrow-kt:arrow-typeclasses:$arrowVersion")
    implementation("io.arrow-kt:arrow-data:$arrowVersion")
    implementation("io.arrow-kt:arrow-instances-core:$arrowVersion")
    implementation("io.arrow-kt:arrow-instances-data:$arrowVersion")
    implementation("io.arrow-kt:arrow-effects:$arrowVersion")
    implementation("io.arrow-kt:arrow-optics:$arrowVersion")
}

dependencies {
    testImplementation(kotlin("test", kotlinVersion))
    testImplementation(kotlin("test-junit5", kotlinVersion))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
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
}
