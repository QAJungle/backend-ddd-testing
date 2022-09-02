package com.qajungle.backendddtesting.domain.book

import com.qajungle.backendddtesting.domain.read.book.BookView
import com.qajungle.backendddtesting.domain.read.book.BookISBNView
import com.qajungle.backendddtesting.domain.read.book.BookIdView
import com.qajungle.backendddtesting.domain.read.book.BookNameView
import com.qajungle.backendddtesting.domain.shared.DomainError
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class BookShould {

  @Test
  fun create_with_a_correct_data() {
    //given
    val id   = BookIdView()
    val isbn = BookISBNView("ISBN")
    val name = BookNameView("NAME")

    //when
    val subject = BookView(id, isbn, name)

    //then
    assertEquals(id, subject.id)
    assertEquals(isbn, subject.isbn)
    assertEquals(name, subject.name)
  }

  @Test
  fun fail_to_create_isbn_with_incorrect_data() {
    //when - then
    assertFailsWith(DomainError::class) {
      BookISBNView("")
    }
  }

  @Test
  fun fail_to_create_name_with_incorrect_data() {
    //when - then
    assertFailsWith(DomainError::class) {
      BookNameView("")
    }
  }
}