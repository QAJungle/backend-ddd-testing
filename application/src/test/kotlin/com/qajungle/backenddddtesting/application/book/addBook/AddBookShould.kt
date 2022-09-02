package com.qajungle.backenddddtesting.application.book.addBook

import com.qajungle.backendddtesting.domain.write.BookWriter
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import io.mockk.verify
import java.util.*
import kotlin.test.BeforeTest
import kotlin.test.Test

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
        val command = AddBookCommand(
            UUID.randomUUID(),
            "ISBN",
            "NAME"
        )

        //-- when
        subject.handle(command)

        //-- then
        verify { writer.add(any()) }
    }
}