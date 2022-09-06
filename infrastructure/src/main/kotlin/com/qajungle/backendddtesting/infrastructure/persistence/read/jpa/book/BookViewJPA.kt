package com.qajungle.backendddtesting.infrastructure.persistence.read.jpa.book

import com.qajungle.backendddtesting.domain.read.book.BookIdView
import com.qajungle.backendddtesting.domain.read.book.BookReader
import com.qajungle.backendddtesting.domain.read.book.BookView
import org.springframework.stereotype.Component

@Component
class BookViewJPA(private val repository: BookJPAReaderRepository) : BookReader {

  override fun findById(id: BookIdView): BookView? {
    return repository.findById(id.value).get().toDomain()
  }
}
