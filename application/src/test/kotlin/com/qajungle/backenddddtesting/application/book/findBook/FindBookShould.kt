package com.qajungle.backenddddtesting.application.book.findBook

import com.qajungle.backendddtesting.domain.read.book.*
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import java.util.*
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class FindBookShould {

  @MockK
  lateinit var reader: BookReader

  @InjectMockKs
  lateinit var subject : FindBook

  @BeforeTest
  fun setUp() = MockKAnnotations.init(this)

  @Test
  fun find_a_book() {
    //-- given
    val query = FindBookQuery(UUID.randomUUID())
    //and
    val book = BookView(
      BookIdView(),
      BookISBNView("ISBN"),
      BookNameView("NAME")
    )
    every { reader.findById(any()) } returns book

    //-- when
    val result = subject.handle(query)

    //-- then
    assertEquals(result, book)
    //and
    verify { reader.findById(any()) }
  }
}