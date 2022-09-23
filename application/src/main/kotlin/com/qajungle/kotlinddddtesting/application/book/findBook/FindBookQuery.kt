package com.qajungle.kotlinddddtesting.application.book.findBook

import com.qajungle.kotlindddtesting.domain.read.book.BookView
import com.trendyol.kediatr.Query
import java.util.UUID

data class FindBookQuery (val id : UUID) : Query<BookView?>