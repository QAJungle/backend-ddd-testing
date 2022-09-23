package com.qajungle.kotlinddddtesting.application.book.findBook

import com.qajungle.kotlinddddtesting.application.book.stub.BookBusStub
import com.qajungle.kotlinddddtesting.application.book.stub.BookStub
import com.qajungle.kotlindddtesting.domain.read.book.BookIdView
import com.qajungle.kotlindddtesting.domain.read.book.BookReader
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.slot
import io.mockk.verify
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
    val query = BookBusStub.findBookQuery()
    //-- and
    val book = BookStub.view()
    val bookIdSlot = slot<BookIdView>()
    every { reader.findById(capture(bookIdSlot)) } returns book

    //-- when
    val result = subject.handle(query)

    //-- then
    assertEquals(result, book)
    //-- and
    assertEquals(query.id, bookIdSlot.captured.value)
    verify { reader.findById(any()) } //We have already verified the method call in the previous step
  }
}