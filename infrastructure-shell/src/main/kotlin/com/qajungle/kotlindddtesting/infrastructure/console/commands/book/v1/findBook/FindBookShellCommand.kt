package com.qajungle.kotlindddtesting.infrastructure.console.commands.book.v1.findBook

import com.qajungle.kotlinddddtesting.application.book.findBook.FindBookQuery
import com.qajungle.kotlindddtesting.domain.read.book.BookNotFound
import com.qajungle.kotlindddtesting.infrastructure.console.commands.book.v1.presenter.BookPresenter
import com.qajungle.kotlindddtesting.infrastructure.console.shared.Help
import com.trendyol.kediatr.CommandBus
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption
import java.util.UUID

@ShellComponent
class FindBookShellCommand(
  private val commandBus: CommandBus,
  private val presenter: BookPresenter
) {

  @ShellMethod(
    key = ["find-book", "fb"],
    value = "Find a book",
    group = "Book management")
  fun get(
    @ShellOption(value = ["-i", "--id"] , help = Help.HELP_BOOK_ID) bookId : UUID
  ) {
    val book = commandBus.executeQuery(FindBookQuery(bookId))
    book?: throw BookNotFound(bookId)
    presenter.print(book)
  }
}