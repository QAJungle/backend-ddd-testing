package com.qajungle.kotlindddtesting.infrastructure.rest.e2e

import com.qajungle.kotlindddtesting.infrastructure.rest.e2e.stub.SerializableBookStub
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import kotlinx.serialization.Required
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.apache.http.HttpStatus
import org.junit.jupiter.api.Test
import org.hamcrest.Matchers.equalTo

class BookRestApplicationShould : BaseTest() {

  @Test
  fun add_a_new_book_and_find_again() {
    val requestBody = SerializableBookStub.get()

    val bookId: String = Given {
      spec(requestSpecification)
      body(Json.encodeToString(requestBody))
    } When {
      post("/books/v1")
    } Then {
      statusCode(HttpStatus.SC_CREATED)
      body("isbn", equalTo(requestBody.isbn))
      body("name", equalTo(requestBody.name))
    } Extract {
      path("id")
    }

    Given {
      spec(requestSpecification)
    } When {
      get("/books/v1/${bookId}")
    } Then {
      statusCode(HttpStatus.SC_OK)
      body("id", equalTo(bookId))
      body("isbn", equalTo(requestBody.isbn))
      body("name", equalTo(requestBody.name))
    }
  }
}
