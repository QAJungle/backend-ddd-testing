package com.qajungle.backenddddtesting.application.book.findBook

import com.qajungle.backendddtesting.domain.read.book.Book
import com.qajungle.backendddtesting.shared.messagebus.core.query.Query
import java.util.Optional
import java.util.UUID

data class FindBookQuery (val id : UUID) : Query<Book?>