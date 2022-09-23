package com.qajungle.kotlinddddtesting.application.book.findBook

import com.qajungle.kotlindddtesting.domain.read.book.BookView
import com.qajungle.kotlindddtesting.domain.read.book.BookIdView
import com.qajungle.kotlindddtesting.domain.read.book.BookReader
import com.trendyol.kediatr.QueryHandler

class FindBook(private val reader : BookReader) : QueryHandler<FindBookQuery, BookView?> {
  override fun handle(query: FindBookQuery) : BookView? {
    val bookId = BookIdView(query.id)
    return reader.findById(bookId)
  }
}
