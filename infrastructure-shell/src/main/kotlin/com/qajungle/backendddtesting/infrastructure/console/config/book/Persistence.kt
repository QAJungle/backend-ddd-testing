package com.qajungle.backendddtesting.infrastructure.console.config.book

import com.qajungle.backendddtesting.domain.read.book.BookReader
import com.qajungle.backendddtesting.domain.write.BookWriter
import com.qajungle.backendddtesting.infrastructure.persistence.read.jpa.book.BookJPAReaderRepository
import com.qajungle.backendddtesting.infrastructure.persistence.read.jpa.book.BookViewJPA
import com.qajungle.backendddtesting.infrastructure.persistence.write.jpa.book.BookJPA
import com.qajungle.backendddtesting.infrastructure.persistence.write.jpa.book.BookJPARepository
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = ["com.qajungle.backendddtesting.infrastructure.persistence"])
@EntityScan("com.qajungle.backendddtesting.infrastructure.persistence")
class Persistence {

  @Bean
  fun bookReader(repository: BookJPAReaderRepository): BookReader? {
    return BookViewJPA(repository)
  }

  @Bean
  fun bookWriter(repository: BookJPARepository): BookWriter? {
    return BookJPA(repository)
  }
}