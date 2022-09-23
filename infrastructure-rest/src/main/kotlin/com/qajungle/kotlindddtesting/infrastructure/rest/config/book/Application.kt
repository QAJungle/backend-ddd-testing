package com.qajungle.kotlindddtesting.infrastructure.rest.config.book

import com.qajungle.kotlinddddtesting.application.book.addBook.AddBook
import com.qajungle.kotlinddddtesting.application.book.findBook.FindBook
import com.qajungle.kotlindddtesting.domain.read.book.BookReader
import com.qajungle.kotlindddtesting.domain.write.BookWriter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class Application {

  @Bean
  fun findBook(reader: BookReader): FindBook {
    return FindBook(reader)
  }

  @Bean
  fun addBook(writer: BookWriter): AddBook {
    return AddBook(writer)
  }
}