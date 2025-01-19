package org.example.moviecachinggateway.dto.validation.validator

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import org.example.moviecachinggateway.dto.validation.ValidYear
import java.time.Year

class YearValidator: ConstraintValidator<ValidYear, Int?> {
    override fun isValid(value: Int?, context: ConstraintValidatorContext): Boolean {
        if (value == null) return false
        if (value < WORLD_FIRST_MOVIE_YEAR) return false

        val currentYear = Year.now().value

        return value >= currentYear
    }

    companion object {
        const val WORLD_FIRST_MOVIE_YEAR = 1895
    }
}