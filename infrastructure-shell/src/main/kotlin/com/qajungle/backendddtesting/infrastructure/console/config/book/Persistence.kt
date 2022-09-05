package com.qajungle.backendddtesting.infrastructure.console.config.book

import com.qajungle.backendddtesting.domain.read.book.BookReader
import com.qajungle.backendddtesting.domain.write.BookWriter
import com.qajungle.backendddtesting.infrastructure.persistence.read.jpa.book.BookJPAReaderRepository
import com.qajungle.backendddtesting.infrastructure.persistence.read.memory.book.BookViewMemory
import com.qajungle.backendddtesting.infrastructure.persistence.write.console.book.BookWriterConsole
import com.qajungle.backendddtesting.infrastructure.persistence.write.jpa.book.BookJPA
import com.qajungle.backendddtesting.infrastructure.persistence.write.jpa.book.BookJPARepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Persistence {

  @Bean
  fun bookReader(repository: BookJPAReaderRepository): BookReader? {
    return BookViewMemory()
  }

  @Bean
  fun bookWriter(repository: BookJPARepository): BookWriter? {
    return BookJPA(repository)
  }
}