package com.qajungle.kotlindddtesting.infrastructure.persistence.read.jpa.book

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface BookJPAReaderRepository : JpaRepository<BookViewJPAEntity, UUID>