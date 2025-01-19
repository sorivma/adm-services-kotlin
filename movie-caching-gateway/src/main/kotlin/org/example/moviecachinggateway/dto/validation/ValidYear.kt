package org.example.moviecachinggateway.dto.validation

import jakarta.validation.Constraint
import org.example.moviecachinggateway.dto.validation.validator.YearValidator
import kotlin.reflect.KClass

@Constraint(validatedBy = [YearValidator::class])
@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class ValidYear (
    val message: String = "Year must be the current year or later",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Any>> = []
)