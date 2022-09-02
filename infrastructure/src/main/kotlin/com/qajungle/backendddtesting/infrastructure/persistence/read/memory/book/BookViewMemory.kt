package com.qajungle.backendddtesting.infrastructure.persistence.read.memory.book

import com.qajungle.backendddtesting.domain.read.book.*

class BookViewMemory : BookReader {
  override fun findById(id: BookIdView): BookView? {
    return BookView(
      BookIdView(),
      BookISBNView("BookISBN"),
      BookNameView("BookName")
    )
  }
}