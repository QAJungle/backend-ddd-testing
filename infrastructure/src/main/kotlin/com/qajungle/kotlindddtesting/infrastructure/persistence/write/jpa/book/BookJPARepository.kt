package com.qajungle.kotlindddtesting.infrastructure.persistence.write.jpa.book

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface BookJPARepository : JpaRepository<BookJPAEntity, UUID>