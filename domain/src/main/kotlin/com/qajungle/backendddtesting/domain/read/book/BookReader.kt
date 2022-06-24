package com.qajungle.backendddtesting.domain.read.book

interface BookReader {
  fun findById(id: BookId) : Book?
}