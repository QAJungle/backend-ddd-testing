plugins {
  id("org.springframework.boot") version "2.7.1"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  id("com.avast.gradle.docker-compose") version "0.16.9"

  kotlin("jvm")
  kotlin("plugin.spring") version "1.6.21"
  kotlin("plugin.serialization") version "1.6.21"
}

group = "com.qajungle"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
  mavenCentral()
}

sourceSets {
  create("integrationTest") {
    compileClasspath += sourceSets.main.get().output
    runtimeClasspath += sourceSets.main.get().output
  }
  create("e2eTest") {
    compileClasspath += sourceSets.main.get().output
    runtimeClasspath += sourceSets.main.get().output
  }
}

val integrationTestImplementation by configurations.getting {
  extendsFrom(configurations.testImplementation.get())
}

val e2eTestImplementation by configurations.getting {
  extendsFrom(configurations.testImplementation.get())
}

configurations["integrationTestRuntimeOnly"].extendsFrom(configurations.testRuntimeOnly.get())
configurations["e2eTestRuntimeOnly"].extendsFrom(configurations.testRuntimeOnly.get())

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
  testImplementation("net.datafaker:datafaker:1.5.0")

  integrationTestImplementation("org.testcontainers:postgresql:1.17.3")
  integrationTestImplementation("org.testcontainers:junit-jupiter:1.17.3")

  e2eTestImplementation("io.rest-assured:kotlin-extensions:5.1.1")
  e2eTestImplementation("org.hamcrest:hamcrest:2.2")
  e2eTestImplementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
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

val integrationTest = task<Test>("integrationTest") {
  description = "Runs integration tests."
  group = "verification"

  testClassesDirs = sourceSets["integrationTest"].output.classesDirs
  classpath = sourceSets["integrationTest"].runtimeClasspath

  useJUnitPlatform()
  shouldRunAfter("test")
}

val e2eTest = task<Test>("e2eTest") {
  description = "Runs E2E tests."
  group = "verification"

  testClassesDirs = sourceSets["e2eTest"].output.classesDirs
  classpath = sourceSets["e2eTest"].runtimeClasspath

  useJUnitPlatform()
}

tasks.check { dependsOn(integrationTest) }

dockerCompose.isRequiredBy(e2eTest)

dockerCompose {
  useComposeFiles.add("../.github/ci/docker-compose.yaml")
  setProjectName("kotlin-ddd-testing")
  projectNamePrefix.plus("_")
}
