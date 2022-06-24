package com.qajungle.backendddtesting.shared.messagebus.core.query

interface QueryHandler<P : Query<T>, T> {
  fun ask(query : P) : T
}