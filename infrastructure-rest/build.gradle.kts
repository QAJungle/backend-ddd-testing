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

sourceSets.create("integrationTest") {
  java.srcDir("src/integrationTest/java")
  java.srcDir("src/integrationTest/kotlin")
  resources.srcDir("src/integrationTest/resources")
}

dependencies {
  implementation(project(":domain"))
  implementation(project(":application"))
  implementation(project(":infrastructure"))

  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.3")
  implementation("org.springdoc:springdoc-openapi-ui:1.6.11")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("com.trendyol:kediatr-spring-starter:1.0.18")

  testImplementation(kotlin("test"))
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.testcontainers:postgresql:1.17.3")
  testImplementation("org.testcontainers:junit-jupiter:1.17.3")
  testImplementation("net.datafaker:datafaker:1.5.0")
}

tasks.bootJar {
  enabled = true
}

tasks.compileKotlin {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "17"
  }
}

tasks.test {
  useJUnitPlatform()
}

tasks.register<Test>("integrationTest") {
  description = "Run integration tests"
  group = "verification"
  testClassesDirs = sourceSets.getByName("integrationTest").compileClasspath
  classpath = sourceSets.getByName("integrationTest").runtimeClasspath
}
