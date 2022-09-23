package com.qajungle.kotlindddtesting.domain.stub

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

class BookStub() {
    companion object {
        private val faker : Faker = Faker()
        fun view() : BookView = BookView(
                BookIdView(UUID.randomUUID()),
                BookISBNView(faker.number().digits(13)),
                BookNameView(faker.book().title()))
        fun get() : Book = Book(
                BookId(UUID.randomUUID()),
                BookISBN(faker.number().digits(13)),
                BookName(faker.book().title())
        )
    }
}