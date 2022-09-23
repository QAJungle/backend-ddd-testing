package com.qajungle.kotlindddtesting.infrastructure.rest.e2e.stub

import kotlinx.serialization.Required
import kotlinx.serialization.Serializable
import net.datafaker.Faker

class SerializableBookStub() {
    companion object {
        private val faker : Faker = Faker()
        fun get() : RequestBook = RequestBook(
          faker.number().digits(13),
          faker.book().title())
    }

  @Serializable
  data class RequestBook(@Required val isbn: String, @Required val name: String)
}