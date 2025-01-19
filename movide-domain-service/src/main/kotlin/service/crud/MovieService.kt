package service.crud

import com.example.movie.Movie
import java.util.UUID

interface MovieService {
    fun findAll(): List<Movie>
    fun findById(id: UUID): Movie?
    fun createMovie(movie: Movie)
    fun updateMovie(movie: Movie)
    fun deleteMovie(id: UUID)
}