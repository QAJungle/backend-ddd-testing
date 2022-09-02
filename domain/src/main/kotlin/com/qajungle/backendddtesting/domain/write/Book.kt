package com.qajungle.backendddtesting.domain.write

import com.qajungle.backendddtesting.domain.shared.AggregateRoot

data class Book (var id   : BookId,
                 var isbn : BookISBN,
                 var name : BookName
) : AggregateRoot()