package com.qajungle.backendddtesting.infrastructure.persistence.initializer

import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container

class BasePersistenceInitilizer : ApplicationContextInitializer<ConfigurableApplicationContext> {

  companion object {
    @Container
    val container = PostgreSQLContainer<Nothing>("postgres:14.5").apply {
      withDatabaseName("backend_ddd_testing")
      withUsername("postgres")
      withPassword("postgres")
    }
  }

  override fun initialize(applicationContext: ConfigurableApplicationContext) {

    container.start()

    TestPropertyValues.of(
      "spring.datasource.url=" + container.jdbcUrl,
      "spring.datasource.username=" + container.username,
      "spring.datasource.password=" + container.password
    ).applyTo(applicationContext.environment);
  }
}