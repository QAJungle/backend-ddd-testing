package com.qajungle.kotlindddtesting.domain.shared

open class DomainError(var errorCode: String, override var message: String) : RuntimeException(message)