package com.qajungle.kotlindddtesting.domain.read.book

interface BookReader {
  fun findById(id: BookIdView) : BookView?
}