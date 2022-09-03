package com.qajungle.backendddtesting.infrastructure.console.commands.book.v1.addBook

import com.qajungle.backenddddtesting.application.book.addBook.AddBookCommand
import com.qajungle.backenddddtesting.application.book.findBook.FindBookQuery
import com.qajungle.backendddtesting.domain.read.book.BookNotFound
import com.qajungle.backendddtesting.infrastructure.console.commands.book.v1.presenter.BookPresenter
import com.qajungle.backendddtesting.infrastructure.console.shared.Help
import com.trendyol.kediatr.CommandBus
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption
import java.util.UUID

@ShellComponent
class AddBookShellCommand(
  private val commandBus: CommandBus,
  private val presenter: BookPresenter) {

  @ShellMethod(
    key = ["add-book", "ab"],
    value = "Add a new book",
    group = "Book management")
  fun get(
    @ShellOption(value = ["-i", "--isbn"] , help = Help.HELP_BOOK_ISBN) isbn : String,
    @ShellOption(value = ["-n", "--name"] , help = Help.HELP_BOOK_NAME) name : String
  ) {
    val bookId = UUID.randomUUID()
    commandBus.executeCommand(AddBookCommand(bookId, isbn, name))

    val book = commandBus.executeQuery(FindBookQuery(bookId))
    book?: throw BookNotFound(bookId)

    presenter.print(book)
  }
}