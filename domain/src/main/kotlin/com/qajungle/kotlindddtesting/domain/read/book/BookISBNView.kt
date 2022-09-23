package com.qajungle.kotlindddtesting.domain.read.book

import com.qajungle.kotlindddtesting.domain.shared.DomainError
import org.valiktor.ConstraintViolationException
import org.valiktor.functions.isNotBlank
import org.valiktor.validate

data class BookISBNView (var value : String) {
    init {
        try {
            validate(this) {
                validate(BookISBNView::value).isNotBlank()
            }
        } catch (ex: ConstraintViolationException) {
            throw DomainError("DOMAIN-001",
                "BookISBN validation error")
        }
    }
}