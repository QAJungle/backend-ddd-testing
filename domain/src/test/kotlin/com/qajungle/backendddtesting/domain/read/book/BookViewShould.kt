package com.qajungle.backendddtesting.domain.read.book

import com.qajungle.backendddtesting.domain.shared.DomainError
import com.qajungle.backendddtesting.domain.stub.BookStub
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class BookViewShould {

  @Test
  fun create_with_a_correct_data() {
    //given
    val id   = BookStub.view().id
    val isbn = BookStub.view().isbn
    val name = BookStub.view().name

    //given
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