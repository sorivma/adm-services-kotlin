package org.example.moviecachinggateway.sevice

import org.example.moviecachinggateway.dto.MovieDto
import java.util.*

interface GetMoviesService {
    fun getMovies() : List<MovieDto>
    fun getMovie(id: UUID) : MovieDto
}