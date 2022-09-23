package com.qajungle.kotlindddtesting.domain.write

import com.qajungle.kotlindddtesting.domain.shared.Identifier
import java.util.UUID

class BookId : Identifier {
  constructor() : super(UUID.randomUUID())
  constructor(value: UUID) : super(value)
}