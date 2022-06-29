package com.qajungle.backendddtesting.infrastructure.web.config.book

import com.qajungle.backendddtesting.domain.read.book.BookReader
import com.qajungle.backendddtesting.infrastructure.persistence.read.memory.book.BookViewMemory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Persistence {

  @Bean
  fun bookReader(): BookReader? {
    return BookViewMemory()
  }
}