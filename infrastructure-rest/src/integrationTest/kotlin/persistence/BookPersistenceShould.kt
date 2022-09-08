package com.qajungle.backendddtesting.infrastructure.persistence

import com.qajungle.backendddtesting.domain.read.book.BookIdView
import com.qajungle.backendddtesting.infrastructure.persistence.initializer.BasePersistenceInitilizer
import com.qajungle.backendddtesting.infrastructure.persistence.read.jpa.book.BookViewJPA
import com.qajungle.backendddtesting.infrastructure.persistence.stub.BookStub
import com.qajungle.backendddtesting.infrastructure.persistence.write.jpa.book.BookJPA
import com.qajungle.backendddtesting.infrastructure.web.config.book.Application
import com.qajungle.backendddtesting.infrastructure.web.config.book.Persistence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ContextConfiguration
import org.testcontainers.junit.jupiter.Testcontainers
import kotlin.test.Test
import kotlin.test.assertEquals

@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(
  classes = [Application::class, Persistence::class],
  initializers = [BasePersistenceInitilizer::class])
internal class BookPersistenceShould {

  @Autowired
  private lateinit var bookJPA: BookJPA

  @Autowired
  private lateinit var bookViewJPA: BookViewJPA

  @Test
  fun add_and_find_a_new_book_into_db() {
    //-- given
    val book = BookStub.get()

    //-- when
    bookJPA.add(book)
    val obtained = bookViewJPA.findById(BookIdView(book.id.value))

    //-- then
    assertEquals(book.id.value, obtained?.id?.value)
    assertEquals("book.isbn.value", obtained?.isbn?.value)
    assertEquals(book.name.value, obtained?.name?.value)
  }
}