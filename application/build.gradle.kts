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

  implementation("com.trendyol:kediatr-spring-starter:1.0.18")

  testImplementation(kotlin("test"))
  testImplementation("io.mockk:mockk:1.12.4")
  testImplementation("net.datafaker:datafaker:1.5.0")
}

tasks.test {
  useJUnitPlatform()
}