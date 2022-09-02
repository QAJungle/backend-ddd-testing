package com.qajungle.backendddtesting.domain.read.book

import com.qajungle.backendddtesting.domain.shared.DomainError
import org.valiktor.ConstraintViolationException
import org.valiktor.functions.isNotBlank
import org.valiktor.validate

data class BookNameView (var value : String) {
    init {
        try {
            validate(this) {
                validate(BookNameView::value).isNotBlank()
            }
        } catch (ex: ConstraintViolationException) {
            throw DomainError("DOMAIN-001",
                "BookName validation error")
        }
    }
}