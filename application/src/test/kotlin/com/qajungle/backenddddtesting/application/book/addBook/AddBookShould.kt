package com.qajungle.backenddddtesting.application.book.addBook

import com.qajungle.backenddddtesting.application.book.stub.BookBusStub
import com.qajungle.backendddtesting.domain.write.Book
import com.qajungle.backendddtesting.domain.write.BookWriter
import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class AddBookShould {

    @RelaxedMockK
    lateinit var writer: BookWriter

    @InjectMockKs
    lateinit var subject: AddBook

    @BeforeTest
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun add_a_book() {
        //-- given
        val command = BookBusStub.addBookCommand()
        //-- and
        val bookSlot = slot<Book>()
        justRun { writer.add(capture(bookSlot)) }

        //-- when
        subject.handle(command)

        //-- then
        assertEquals(command.id, bookSlot.captured.id.value)
        assertEquals(command.isbn, bookSlot.captured.isbn.value)
        assertEquals(command.name, bookSlot.captured.name.value)
        verify { writer.add(any()) } //We have already verified the method call in the previous step
    }
}