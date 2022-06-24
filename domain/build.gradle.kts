plugins {
  kotlin("jvm")
}

group = "com.qajungle"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(kotlin("test"))

  implementation("org.valiktor:valiktor-core:0.12.0")
}

tasks.test {
  useJUnitPlatform()
}