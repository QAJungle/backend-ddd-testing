package com.qajungle.kotlindddtesting.infrastructure.rest.controller.book.v1.addBook

import com.qajungle.kotlinddddtesting.application.book.addBook.AddBookCommand
import com.qajungle.kotlinddddtesting.application.book.findBook.FindBookQuery
import com.qajungle.kotlindddtesting.domain.read.book.BookNotFound
import com.trendyol.kediatr.CommandBus
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/books/v1")
class AddBookController(private val commandBus: CommandBus) {

  @PostMapping
  fun add(@RequestBody request : AddBookRequest) : ResponseEntity<AddBookResponse> {
    val bookId = UUID.randomUUID()
    commandBus.executeCommand(
      AddBookCommand(
      bookId,
      request.isbn,
      request.name)
    )

    val book = commandBus.executeQuery(FindBookQuery(bookId))
    book?: throw BookNotFound(bookId)

    return ResponseEntity(
      AddBookResponse(
      book.id.value.toString(),
      book.isbn.value,
      book.name.value),
      HttpStatus.CREATED)
  }
}