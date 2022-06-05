import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
    java
    jacoco
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("junit:junit:4.13.1")
    // https://mvnrepository.com/artifact/org.jacoco/org.jacoco.agent
    testImplementation("org.jacoco:org.jacoco.agent:0.8.8")
}
