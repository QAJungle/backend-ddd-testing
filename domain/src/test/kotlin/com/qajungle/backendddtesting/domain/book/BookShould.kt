package com.qajungle.backendddtesting.domain.book

import com.qajungle.backendddtesting.domain.read.book.Book
import com.qajungle.backendddtesting.domain.read.book.BookISBN
import com.qajungle.backendddtesting.domain.read.book.BookId
import com.qajungle.backendddtesting.domain.read.book.BookName
import com.qajungle.backendddtesting.domain.shared.DomainError
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class BookShould {

  @Test
  fun create_with_a_correct_data() {
    //given
    val id   = BookId()
    val isbn = BookISBN("ISBN")
    val name = BookName("NAME")

    //when
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