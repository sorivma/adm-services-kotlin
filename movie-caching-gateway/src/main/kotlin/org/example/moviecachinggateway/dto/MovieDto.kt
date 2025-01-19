package org.example.moviecachinggateway.dto

import com.fasterxml.jackson.annotation.JsonInclude
import org.example.moviecachinggateway.dto.validation.ValidYear
import org.hibernate.validator.constraints.Length
import java.io.Serializable
import java.util.*

data class MovieDto(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val id: UUID? = null,
    @Length(min = 1, max = 50, message = "Movie title shall not exceed 50 characters or be less then 1 character.")
    val title: String,
    @Length(min = 1, max = 50, message = "Movie title shall not exceed 50 characters or be less then 1 character.")
    val director: String,
    @Length(min = 1, max = 50, message = "Movie title shall not exceed 50 characters or be less then 1 character.")
    val genre: String,
    @ValidYear
    val releaseYear: Int,
): Serializable
