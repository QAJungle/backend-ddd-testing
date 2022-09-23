package com.qajungle.kotlindddtesting.domain.read.book

import com.qajungle.kotlindddtesting.domain.shared.Identifier
import java.util.UUID

class BookIdView : Identifier {
  constructor() : super(UUID.randomUUID())
  constructor(value: UUID) : super(value)
}