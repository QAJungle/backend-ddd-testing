package com.qajungle.backendddtesting.domain.read.book

import com.qajungle.backendddtesting.domain.shared.Identifier
import java.util.UUID

class BookIdView : Identifier {
  constructor() : super(UUID.randomUUID())
  constructor(value: UUID) : super(value)
}