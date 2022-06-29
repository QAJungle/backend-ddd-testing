plugins {
    kotlin("jvm")
}

group = "com.qajungle"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":application"))

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}