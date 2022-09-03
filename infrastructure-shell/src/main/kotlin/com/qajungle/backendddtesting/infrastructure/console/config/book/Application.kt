package com.qajungle.backendddtesting.infrastructure.console.config.book

import com.qajungle.backenddddtesting.application.book.addBook.AddBook
import com.qajungle.backenddddtesting.application.book.findBook.FindBook
import com.qajungle.backendddtesting.domain.read.book.BookReader
import com.qajungle.backendddtesting.domain.write.BookWriter
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