package com.qajungle.kotlindddtesting.infrastructure.persistence.stub

import com.qajungle.kotlindddtesting.domain.write.Book
import com.qajungle.kotlindddtesting.domain.write.BookISBN
import com.qajungle.kotlindddtesting.domain.write.BookId
import com.qajungle.kotlindddtesting.domain.write.BookName
import net.datafaker.Faker
import java.util.UUID

class BookStub() {
    companion object {
        private val faker : Faker = Faker()
        fun get() : Book = Book(
                BookId(UUID.randomUUID()),
                BookISBN(faker.number().digits(13)),
                BookName(faker.book().title())
        )
    }
}