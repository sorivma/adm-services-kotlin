package service.grpc

import Extensions.toUUID
import com.example.movie.*
import io.grpc.stub.StreamObserver
import service.crud.MovieService

class MovieServiceImpl(private val movieService: MovieService) : MovieServiceGrpc.MovieServiceImplBase() {
    override fun getMovieById(request: GetMovieRequest, responseObserver: StreamObserver<GetMovieResponse>) {
        try {
            val response = GetMovieResponse.newBuilder().setMovie(movieService.findById(request.id.toUUID())).build()
            responseObserver.onNext(response)
        } catch (e: Exception) {
            responseObserver.onError(e)
        }
    }

    override fun listMovies(request: Empty?, responseObserver: StreamObserver<MovieList>?) {
        try {
            val response = MovieList.newBuilder().addAllMovies(movieService.findAll()).build()
            responseObserver?.onNext(response)
        } catch (e: Exception) {
            responseObserver?.onError(e)
        }
    }
}