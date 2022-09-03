package com.qajungle.backendddtesting.infrastructure.console.commands.book.v1.presenter

import com.qajungle.backendddtesting.domain.read.book.BookView
import org.jline.terminal.Terminal
import org.springframework.stereotype.Component

@Component
class BookPresenter(private val terminal : Terminal) {

  fun print(bookView : BookView) {
    terminal.writer().println("" +
            "Book ID: ${bookView.id.value} \n" +
            "Book ISBN: ${bookView.isbn.value} \n" +
            "Book name: ${bookView.name.value}")
    terminal.flush()
  }
}