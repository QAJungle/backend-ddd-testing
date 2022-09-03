package com.qajungle.backendddtesting.infrastructure.console.commands.book.v1.findBook

import com.qajungle.backenddddtesting.application.book.findBook.FindBookQuery
import com.qajungle.backendddtesting.domain.read.book.BookNotFound
import com.qajungle.backendddtesting.infrastructure.console.commands.book.v1.presenter.BookPresenter
import com.trendyol.kediatr.CommandBus
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption
import java.util.UUID

@ShellComponent
class FindBookShellCommand(
  private val commandBus: CommandBus,
  private val presenter: BookPresenter) {

  @ShellMethod(
    key = ["get-book", "gb"],
    value = "Get a book",
    group = "Book management")
  fun get(
    @ShellOption(value = ["-i"] , help = "Id field", defaultValue = "id") bookId : UUID
  ) {
    val book = commandBus.executeQuery(FindBookQuery(bookId))
    book?: throw BookNotFound(bookId)
    presenter.print(book)
  }
}