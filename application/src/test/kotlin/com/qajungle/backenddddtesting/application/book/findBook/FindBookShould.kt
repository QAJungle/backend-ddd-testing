package com.qajungle.backenddddtesting.application.book.findBook

import com.lookiero.platform.backendddtesting.domain.read.book.*
import com.qajungle.backendddtesting.domain.read.book.*
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

class FindBookShould {

  @MockK
  lateinit var reader: BookReader

  @InjectMockKs
  lateinit var subject : FindBook

  @Test
  fun find_a_book() {
    //-- given
    val query = FindBookQuery(UUID.randomUUID())
    //and
    val book = Book(
      BookId(),
      BookISBN("ISBN"),
      BookName("NAME")
    )

    every { reader.findById(any()) } returns book

    //-- when
    val result = subject.ask(query)

    //-- then
    assertEquals(result, book)
    //and
    verify { reader.findById(any()) }
  }
}