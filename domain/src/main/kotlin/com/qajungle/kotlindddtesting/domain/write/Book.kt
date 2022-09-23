package com.qajungle.kotlindddtesting.domain.write

import com.qajungle.kotlindddtesting.domain.shared.AggregateRoot

data class Book (var id   : BookId,
                 var isbn : BookISBN,
                 var name : BookName
) : AggregateRoot()