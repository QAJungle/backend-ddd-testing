package com.qajungle.kotlinddddtesting.application.book.addBook

import com.qajungle.kotlindddtesting.domain.write.*
import com.trendyol.kediatr.CommandHandler

class AddBook(private val writer : BookWriter) : CommandHandler<AddBookCommand> {

  override fun handle(command: AddBookCommand) {
    val book = Book(
      BookId(command.id),
      BookISBN(command.isbn),
      BookName(command.name)
    )
    writer.add(book)
  }
}
