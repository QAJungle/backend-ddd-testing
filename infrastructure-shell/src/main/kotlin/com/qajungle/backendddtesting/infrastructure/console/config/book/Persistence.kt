package com.qajungle.backendddtesting.infrastructure.console.config.book

import com.qajungle.backendddtesting.domain.read.book.BookReader
import com.qajungle.backendddtesting.domain.write.BookWriter
import com.qajungle.backendddtesting.infrastructure.persistence.read.memory.book.BookViewMemory
import com.qajungle.backendddtesting.infrastructure.persistence.write.console.book.BookWriterConsole
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Persistence {

  @Bean
  fun bookReader(): BookReader? {
    return BookViewMemory()
  }

  @Bean
  fun bookWriter(): BookWriter? {
    return BookWriterConsole()
  }
}