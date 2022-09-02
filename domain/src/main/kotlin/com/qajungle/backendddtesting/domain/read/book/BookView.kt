package com.qajungle.backendddtesting.domain.read.book

import com.qajungle.backendddtesting.domain.shared.AggregateRoot

data class BookView (var id   : BookIdView,
                     var isbn : BookISBNView,
                     var name : BookNameView
) : AggregateRoot()