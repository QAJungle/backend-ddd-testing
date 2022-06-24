package com.qajungle.backendddtesting.shared.messagebus.core.query

interface QueryBus {
  fun <T> ask(query: Query<T>) : T
}