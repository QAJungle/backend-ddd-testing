package com.qajungle.kotlindddtesting.infrastructure.rest.e2e

import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.config.LogConfig
import io.restassured.config.RestAssuredConfig
import io.restassured.filter.log.LogDetail
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import kotlin.test.BeforeTest

open class BaseTest {

  companion object {
    lateinit var requestSpecification: RequestSpecification
  }

  @BeforeTest
  fun setUp() {
    val logConfig = LogConfig.logConfig()
      .enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)
    val config = RestAssuredConfig.config().logConfig(logConfig)

    requestSpecification = RequestSpecBuilder()
      .setBaseUri("http://localhost")
      .setContentType(ContentType.JSON)
      .setRelaxedHTTPSValidation()
      .setConfig(config)
      .build()
  }

  @BeforeTest
  fun tearDown(){
    RestAssured.reset()
  }

}