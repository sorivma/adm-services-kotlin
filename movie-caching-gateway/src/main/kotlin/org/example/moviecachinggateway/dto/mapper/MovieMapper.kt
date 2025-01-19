package org.example.moviecachinggateway.dto.mapper

import com.example.movie.Movie
import org.example.moviecachinggateway.dto.MovieDto
import org.example.moviecachinggateway.util.Extensions.toUUID

object MovieMapper {
    fun Movie.toDto(): MovieDto {
        return MovieDto(
            id = this.id.toUUID(),
            title = this.title,
            director = this.director,
            genre = this.genre,
            releaseYear = this.releaseYear,
        )
    }

    fun MovieDto.toProto(): Movie {
        return Movie.newBuilder()
            .setId(this.id.toString())
            .setTitle(this.title)
            .setDirector(this.director)
            .setGenre(this.genre)
            .setReleaseYear(this.releaseYear)
            .build()
    }
}