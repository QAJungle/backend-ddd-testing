package com.qajungle.backendddtesting.domain.read.book

interface BookReader {
  fun findById(id: BookIdView) : BookView?
}