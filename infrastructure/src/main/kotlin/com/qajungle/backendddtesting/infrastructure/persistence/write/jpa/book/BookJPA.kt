package com.qajungle.backendddtesting.infrastructure.persistence.write.jpa.book

import com.qajungle.backendddtesting.domain.write.Book
import com.qajungle.backendddtesting.domain.write.BookWriter
import org.springframework.stereotype.Component

@Component
class BookJPA(private val repository: BookJPARepository) : BookWriter {

  override fun add(book: Book) {
    val entity = BookJPAEntity.fromDomain(book)
    repository.save(entity)
  }
}
