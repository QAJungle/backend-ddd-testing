package com.qajungle.backendddtesting.infrastructure.persistence.write.jpa.book

import com.qajungle.backendddtesting.domain.write.Book
import com.qajungle.backendddtesting.domain.write.BookISBN
import com.qajungle.backendddtesting.domain.write.BookId
import com.qajungle.backendddtesting.domain.write.BookName
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(
  name = "books"
)
class BookJPAEntity (
  @Id val id : UUID,
  @Column(nullable = false) val isbn : String,
  @Column(nullable = false) val name : String,
) {

  fun toDomain() : Book {
    return Book(
      BookId(id),
      BookISBN(isbn),
      BookName(name)
    )
  }

  companion object {
    fun fromDomain(book: Book) : BookJPAEntity {
      return BookJPAEntity(
        book.id.value,
        book.isbn.value,
        book.name.value
      )
    }
  }
}