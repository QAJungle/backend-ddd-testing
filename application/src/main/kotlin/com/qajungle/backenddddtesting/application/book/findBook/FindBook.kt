package com.qajungle.backenddddtesting.application.book.findBook

import com.qajungle.backendddtesting.domain.read.book.Book
import com.qajungle.backendddtesting.domain.read.book.BookId
import com.qajungle.backendddtesting.domain.read.book.BookReader
import com.trendyol.kediatr.QueryHandler

class FindBook(val reader : BookReader) : QueryHandler<FindBookQuery, Book?> {

  override fun handle(query: FindBookQuery) : Book? {
    val bookId = BookId(query.id)
    return reader.findById(bookId)
  }

}
