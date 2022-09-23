package com.qajungle.kotlinddddtesting.application.book.addBook

import com.trendyol.kediatr.Command
import java.util.UUID

data class AddBookCommand (
    val id : UUID,
    val isbn : String,
    val name : String) : Command
