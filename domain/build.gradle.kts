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
  testImplementation("net.datafaker:datafaker:1.5.0")
}

tasks.test {
  useJUnitPlatform()
}