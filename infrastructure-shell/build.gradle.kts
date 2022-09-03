plugins {
  id("org.springframework.boot") version "2.7.1"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  kotlin("jvm")
  kotlin("plugin.spring") version "1.6.21"
}

group = "com.qajungle"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
  mavenCentral()
}

dependencies {
  implementation(project(":domain"))
  implementation(project(":application"))
  implementation(project(":infrastructure"))

  implementation("org.springframework.shell:spring-shell-starter:2.1.1")
  implementation("com.trendyol:kediatr-spring-starter:1.0.18")

  testImplementation(kotlin("test"))
}

tasks.bootJar {
  enabled = true
}

tasks.test {
  useJUnitPlatform()
}