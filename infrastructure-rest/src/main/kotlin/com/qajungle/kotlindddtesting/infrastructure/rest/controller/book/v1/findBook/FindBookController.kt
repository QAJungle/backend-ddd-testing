package com.qajungle.kotlindddtesting.infrastructure.rest.controller.book.v1.findBook

import com.qajungle.kotlinddddtesting.application.book.findBook.FindBookQuery
import com.qajungle.kotlindddtesting.domain.read.book.BookNotFound
import com.trendyol.kediatr.CommandBus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/books/v1")
class FindBookController(private val commandBus: CommandBus) {

  @GetMapping("/{bookId}")
  fun get(@PathVariable bookId: UUID) : ResponseEntity<FindBookResponse> {
    val book = commandBus.executeQuery(FindBookQuery(bookId))
    book?: throw BookNotFound(bookId)

    return ResponseEntity.ok(
      FindBookResponse(
      book.id.value.toString(),
      book.isbn.value,
      book.name.value)
    )
  }
}