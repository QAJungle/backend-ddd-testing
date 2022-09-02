package com.qajungle.backendddtesting.domain.write

import com.qajungle.backendddtesting.domain.shared.Identifier
import java.util.UUID

class BookId : Identifier {
  constructor() : super(UUID.randomUUID())
  constructor(value: UUID) : super(value)
}