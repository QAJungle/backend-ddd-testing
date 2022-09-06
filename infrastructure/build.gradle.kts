plugins {
  kotlin("jvm")
  kotlin("plugin.spring") version "1.6.21"
  kotlin("plugin.jpa") version "1.6.21"
}

group = "com.qajungle"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation(project(":domain"))
  implementation(project(":application"))

  implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.3")
  implementation("org.postgresql:postgresql:42.5.0")

  testImplementation(kotlin("test"))
}

tasks.test {
  useJUnitPlatform()
}