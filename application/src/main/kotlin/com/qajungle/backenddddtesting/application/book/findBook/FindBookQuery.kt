package com.qajungle.backenddddtesting.application.book.findBook

import com.qajungle.backendddtesting.domain.read.book.Book
import com.trendyol.kediatr.Query
import java.util.UUID

data class FindBookQuery (val id : UUID) : Query<Book?>