package org.example.moviecachinggateway.sevice.impl

import com.example.movie.MovieServiceGrpc
import org.example.moviecachinggateway.dto.MovieDto
import org.example.moviecachinggateway.sevice.GetMoviesService
import org.springframework.stereotype.Service
import java.util.*

@Service
class GrpcGetMoviesService(private val stub: MovieServiceGrpc.MovieServiceBlockingStub) : GetMoviesService {
    override fun getMovies(): List<MovieDto> {
        TODO("Not yet implemented")
    }

    override fun getMovie(id: UUID): MovieDto {
        TODO("Not yet implemented")
    }
}