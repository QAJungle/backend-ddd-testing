package com.qajungle.backendddtesting.infrastructure.persistence.write.console.book

import com.qajungle.backendddtesting.domain.write.Book
import com.qajungle.backendddtesting.domain.write.BookWriter

class BookWriterConsole : BookWriter {
  override fun add(book: Book) {
    println("Book ${book.id.value} :: ${book.name.value} :: ${book.isbn.value}")
  }
}