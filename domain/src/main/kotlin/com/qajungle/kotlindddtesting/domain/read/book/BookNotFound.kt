package com.qajungle.kotlindddtesting.domain.read.book

import com.qajungle.kotlindddtesting.domain.shared.DomainError
import java.util.UUID

class BookNotFound(bookId: UUID) : DomainError("E-001", "Book $bookId not found")