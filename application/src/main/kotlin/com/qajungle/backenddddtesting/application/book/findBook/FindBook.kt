package com.qajungle.backenddddtesting.application.book.findBook

import com.qajungle.backendddtesting.domain.read.book.BookView
import com.qajungle.backendddtesting.domain.read.book.BookIdView
import com.qajungle.backendddtesting.domain.read.book.BookReader
import com.trendyol.kediatr.QueryHandler

class FindBook(val reader : BookReader) : QueryHandler<FindBookQuery, BookView?> {
  override fun handle(query: FindBookQuery) : BookView? {
    val bookId = BookIdView(query.id)
    return reader.findById(bookId)
  }
}
