package com.qajungle.backendddtesting.infrastructure.persistence.read.memory.book

import com.qajungle.backendddtesting.domain.read.book.*

class BookViewMemory : BookReader {
  override fun findById(id: BookId): Book? {
    return Book(
      BookId(),
      BookISBN("BookISBN"),
      BookName("BookName")
    )
  }
}