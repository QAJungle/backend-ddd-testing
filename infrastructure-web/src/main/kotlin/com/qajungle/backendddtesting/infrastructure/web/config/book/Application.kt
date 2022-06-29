package com.qajungle.backendddtesting.infrastructure.web.config.book

import com.qajungle.backenddddtesting.application.book.findBook.FindBook
import com.qajungle.backendddtesting.domain.read.book.BookReader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class Application {

  @Bean
  fun findBook(reader: BookReader): FindBook? {
    return FindBook(reader)
  }
}