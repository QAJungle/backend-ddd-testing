package com.qajungle.kotlindddtesting.domain.read.book

import com.qajungle.kotlindddtesting.domain.shared.AggregateRoot

data class BookView (var id   : BookIdView,
                     var isbn : BookISBNView,
                     var name : BookNameView
) : AggregateRoot()