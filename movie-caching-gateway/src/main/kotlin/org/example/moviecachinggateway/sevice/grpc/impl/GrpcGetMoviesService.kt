package org.example.moviecachinggateway.sevice.grpc.impl

import com.example.movie.Empty
import com.example.movie.GetMovieRequest
import com.example.movie.MovieServiceGrpc
import io.grpc.StatusRuntimeException
import org.example.moviecachinggateway.dto.MovieDto
import org.example.moviecachinggateway.dto.mapper.MovieMapper.toDto
import org.example.moviecachinggateway.sevice.GetMoviesService
import org.example.moviecachinggateway.sevice.grpc.exception.MovieServiceException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.util.*

@Service
class GrpcGetMoviesService(private val stub: MovieServiceGrpc.MovieServiceBlockingStub) : GetMoviesService {
    @Cacheable(value = ["movies"])
    override fun getMovies(): List<MovieDto> {
        log.info("Requested movies list")
        return handleGrpcCall {
            stub.listMovies(Empty.newBuilder().build()).moviesList.map { it.toDto() }
        }
    }

    @Cacheable(value = ["movies"], key = "#id")
    override fun getMovie(id: UUID): MovieDto {
        log.info("Requested movie: $id")
        return handleGrpcCall {
            val request = GetMovieRequest.newBuilder()
                .setId(id.toString())
                .build()

            stub.getMovieById(request).movie.toDto()
        }
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(GrpcGetMoviesService::class.java)

        inline fun <T> handleGrpcCall(block: () -> T): T {
            try {
                return block()
            } catch (e: StatusRuntimeException) {
                log.error("gRPC call failed: Status Code: ${e.status.code}, Description: ${e.status.description}", e)

                throw(e)
            } catch (e: Exception) {
                log.error("Unexpected error while getting data", e)

                throw MovieServiceException("Unexpected error while getting data")
            }
        }
    }
}