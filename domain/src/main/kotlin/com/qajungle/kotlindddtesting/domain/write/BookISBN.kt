package com.qajungle.kotlindddtesting.domain.write

import com.qajungle.kotlindddtesting.domain.shared.DomainError
import org.valiktor.ConstraintViolationException
import org.valiktor.functions.isNotBlank
import org.valiktor.validate

data class BookISBN (var value : String) {
    init {
        try {
            validate(this) {
                validate(BookISBN::value).isNotBlank()
            }
        } catch (ex: ConstraintViolationException) {
            throw DomainError("DOMAIN-001",
                "BookISBN validation error")
        }
    }
}