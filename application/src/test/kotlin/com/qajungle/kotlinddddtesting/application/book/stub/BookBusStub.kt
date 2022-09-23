package com.qajungle.kotlinddddtesting.application.book.stub

import com.qajungle.kotlinddddtesting.application.book.addBook.AddBookCommand
import com.qajungle.kotlinddddtesting.application.book.findBook.FindBookQuery
import com.qajungle.kotlindddtesting.domain.read.book.BookISBNView
import com.qajungle.kotlindddtesting.domain.read.book.BookIdView
import com.qajungle.kotlindddtesting.domain.read.book.BookNameView
import com.qajungle.kotlindddtesting.domain.read.book.BookView
import com.qajungle.kotlindddtesting.domain.write.Book
import com.qajungle.kotlindddtesting.domain.write.BookISBN
import com.qajungle.kotlindddtesting.domain.write.BookId
import com.qajungle.kotlindddtesting.domain.write.BookName
import net.datafaker.Faker
import java.util.UUID

class BookBusStub() {
    companion object {
        private val faker : Faker = Faker()
        fun findBookQuery() : FindBookQuery = FindBookQuery(UUID.randomUUID())
        fun addBookCommand() : AddBookCommand = AddBookCommand(
            UUID.randomUUID(),
            faker.number().digits(13),
            faker.book().title())
    }
}