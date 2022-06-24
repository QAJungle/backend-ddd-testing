package com.qajungle.backendddtesting.domain.read.book

import com.qajungle.backendddtesting.domain.shared.DomainError
import java.util.UUID

class BookNotFound(bookId: UUID) : DomainError("E-001", "Book $bookId not found")