package service.crud.impl

import com.example.movie.Movie
import org.jetbrains.exposed.sql.ResultRow

object MoveMapper {
    fun ResultRow.toMovie(): Movie =
        Movie.newBuilder()
            .setId(
                this[Movies.id].value.toString()
            )
            .setTitle(
                this[Movies.title]
            )
            .setGenre(
                this[Movies.genre]
            )
            .setDirector(
                this[Movies.director]
            )
            .setReleaseYear(
                this[Movies.releaseYear]
            )
            .build()
}
