package com.qajungle.backendddtesting.infrastructure.web.controller.book.v1.findBook

import com.qajungle.backenddddtesting.application.book.findBook.FindBookQuery
import com.qajungle.backendddtesting.domain.read.book.BookNotFound
import com.trendyol.kediatr.CommandBus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/books/v1")
class FindBookController(private val commandBus: CommandBus) {

  @GetMapping("/{bookId}")
  fun get(@PathVariable bookId: UUID) : ResponseEntity<FindBookResponse> {
    val book = commandBus.executeQuery(FindBookQuery(bookId))
    book?: throw BookNotFound(bookId)
    return ResponseEntity.ok(FindBookResponse(
      book.id.value.toString(),
      book.isbn.value,
      book.name.value))
  }
}