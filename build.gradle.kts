val kotlinVersion by project
val junitJupiterVersion by project
val junitPlatformVersion by project

plugins {
    kotlin("jvm") version "1.1.51"
}

repositories {
    jcenter()
//    maven("https://kotlin.bintray.com/kotlinx")
}

dependencies {
    compile(kotlin("stdlib", "$kotlinVersion"))
    compile("io.kategory:kategory:0.3.10")
//    compile("io.kategory:kategory-effects:0.3.10")
//    compile("io.kategory:kategory-optics:0.3.10")
}

dependencies {
    testCompile(kotlin("test", "$kotlinVersion"))
    testCompile("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
    testRuntime("org.junit.platform:junit-platform-launcher:$junitPlatformVersion")
}
