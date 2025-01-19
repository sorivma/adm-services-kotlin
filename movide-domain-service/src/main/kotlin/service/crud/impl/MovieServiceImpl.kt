package service.crud.impl

import Extensions.toUUID
import com.example.movie.Movie
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import service.crud.MovieService
import service.crud.impl.MovieMapper.toMovie
import java.util.*

class MovieServiceImpl : MovieService {

    override fun findAll(): List<Movie> {
        return transaction {
            Movies.selectAll().map {
                it.toMovie()
            }
        }
    }

    override fun findById(id: UUID): Movie? {
        return transaction {
            Movies.selectAll().where { Movies.id eq id }.firstOrNull()?.toMovie()
        }
    }

    override fun createMovie(movie: Movie) {
        transaction {
            Movies.insertAndGetId {
                it[title] = movie.title
                it[director] = movie.director
                it[genre] = movie.genre
                it[releaseYear] = movie.releaseYear
            }
        }
    }

    override fun updateMovie(movie: Movie) {
        transaction {
            Movies.update({ Movies.id eq movie.id.toUUID() }) {
                it[title] = movie.title
                it[director] = movie.director
                it[genre] = movie.genre
                it[releaseYear] = movie.releaseYear
            }
        }
    }

    override fun deleteMovie(id: UUID) {
        return transaction {
            Movies.deleteWhere { Movies.id eq id }
        }
    }
}