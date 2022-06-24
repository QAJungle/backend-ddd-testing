plugins {
  kotlin("jvm")
}

group = "com.qajungle"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation(project(":shared"))
  implementation(project(":domain"))

  testImplementation(kotlin("test"))
  testImplementation("io.mockk:mockk:1.12.4")
}

tasks.test {
  useJUnitPlatform()
}