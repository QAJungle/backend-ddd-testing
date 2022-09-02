package com.qajungle.backendddtesting.domain.write.book

import com.qajungle.backendddtesting.domain.shared.DomainError
import com.qajungle.backendddtesting.domain.stub.BookStub
import com.qajungle.backendddtesting.domain.write.Book
import com.qajungle.backendddtesting.domain.write.BookISBN
import com.qajungle.backendddtesting.domain.write.BookName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class BookShould {

  @Test
  fun create_with_a_correct_data() {
    //given
    val id   = BookStub.get().id
    val isbn = BookStub.get().isbn
    val name = BookStub.get().name

    //given
    val subject = Book(id, isbn, name)

    //then
    assertEquals(id, subject.id)
    assertEquals(isbn, subject.isbn)
    assertEquals(name, subject.name)
  }

  @Test
  fun fail_to_create_isbn_with_incorrect_data() {
    //when - then
    assertFailsWith(DomainError::class) {
      BookISBN("")
    }
  }

  @Test
  fun fail_to_create_name_with_incorrect_data() {
    //when - then
    assertFailsWith(DomainError::class) {
      BookName("")
    }
  }
}