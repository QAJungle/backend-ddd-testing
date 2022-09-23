package com.qajungle.kotlindddtesting.infrastructure.persistence.write.jpa.book

import com.qajungle.kotlindddtesting.domain.write.Book
import com.qajungle.kotlindddtesting.domain.write.BookWriter
import org.springframework.stereotype.Component

@Component
class BookJPA(private val repository: BookJPARepository) : BookWriter {

  override fun add(book: Book) {
    val entity = BookJPAEntity.fromDomain(book)
    repository.save(entity)
    repository.flush()
  }
}
