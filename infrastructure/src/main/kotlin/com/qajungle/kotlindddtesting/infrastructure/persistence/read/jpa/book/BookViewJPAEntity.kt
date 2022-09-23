package com.qajungle.kotlindddtesting.infrastructure.persistence.read.jpa.book

import com.qajungle.kotlindddtesting.domain.read.book.BookISBNView
import com.qajungle.kotlindddtesting.domain.read.book.BookIdView
import com.qajungle.kotlindddtesting.domain.read.book.BookNameView
import com.qajungle.kotlindddtesting.domain.read.book.BookView
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(
  name = "books"
)
class BookViewJPAEntity (
  @Id val id : UUID,
  @Column(nullable = false) val isbn : String,
  @Column(nullable = false) val name : String,
) {

  fun toDomain() : BookView {
    return BookView(
      BookIdView(id),
      BookISBNView(isbn),
      BookNameView(name)
    )
  }

  companion object {
    fun fromDomain(book: BookView) : BookViewJPAEntity {
      return BookViewJPAEntity(
        book.id.value,
        book.isbn.value,
        book.name.value
      )
    }
  }
}