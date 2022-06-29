plugins {
  kotlin("jvm")
}

group = "com.qajungle"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.valiktor:valiktor-core:0.12.0")

  testImplementation(kotlin("test"))
}

tasks.test {
  useJUnitPlatform()
}