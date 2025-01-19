package org.example.moviecachinggateway.sevice

import com.example.movie.Movie
import org.example.moviecachinggateway.dto.MovieDto
import java.util.UUID

interface AsyncOperationService {
    fun updateMovie(movie: MovieDto)
    fun deleteMovie(id: UUID)
    fun postMovie(movie: MovieDto)
}