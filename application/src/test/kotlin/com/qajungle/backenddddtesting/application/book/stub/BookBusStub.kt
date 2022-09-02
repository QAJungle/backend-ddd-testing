package com.qajungle.backenddddtesting.application.book.stub

import com.qajungle.backenddddtesting.application.book.addBook.AddBookCommand
import com.qajungle.backenddddtesting.application.book.findBook.FindBookQuery
import com.qajungle.backendddtesting.domain.read.book.BookISBNView
import com.qajungle.backendddtesting.domain.read.book.BookIdView
import com.qajungle.backendddtesting.domain.read.book.BookNameView
import com.qajungle.backendddtesting.domain.read.book.BookView
import com.qajungle.backendddtesting.domain.write.Book
import com.qajungle.backendddtesting.domain.write.BookISBN
import com.qajungle.backendddtesting.domain.write.BookId
import com.qajungle.backendddtesting.domain.write.BookName
import net.datafaker.Faker
import java.util.UUID

class BookBusStub() {
    companion object {
        private val faker : Faker = Faker()
        fun findBookQuery() :  FindBookQuery = FindBookQuery(UUID.randomUUID())
        fun addBookCommand() : AddBookCommand = AddBookCommand(
            UUID.randomUUID(),
            faker.number().digits(13),
            faker.book().title())
    }
}