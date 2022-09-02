package com.qajungle.backenddddtesting.application.book.addBook

import com.qajungle.backendddtesting.domain.write.*
import com.trendyol.kediatr.CommandHandler

class AddBook(val writer : BookWriter) : CommandHandler<AddBookCommand> {

  override fun handle(command: AddBookCommand) {
    val book = Book(
      BookId(command.id),
      BookISBN(command.isbn),
      BookName(command.name))
    writer.add(book)
  }
}
