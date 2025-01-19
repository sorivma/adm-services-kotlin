package service.grpc

import Extensions.toUUID
import com.example.movie.*
import io.grpc.Status
import io.grpc.stub.StreamObserver
import service.crud.MovieService

class GrpcMovieServiceImpl(private val movieService: MovieService) : MovieServiceGrpc.MovieServiceImplBase() {
    override fun getMovieById(request: GetMovieRequest, responseObserver: StreamObserver<GetMovieResponse>) {
        try {
            movieService.findById(request.id.toUUID())?.let {
                val response = GetMovieResponse.newBuilder().setMovie(it).build()
                responseObserver.onNext(response)
                responseObserver.onCompleted()
                return
            }
            responseObserver.onError(
                Status.NOT_FOUND
                    .withDescription(
                        "Movie with specified id [${request.id} ]not found.").asRuntimeException()
            )
        }
        catch (e: Exception) {
            println(e.message)
            responseObserver.onError(e)
        }
    }

    override fun listMovies(request: Empty?, responseObserver: StreamObserver<MovieList>?) {
        try {
            val response = MovieList.newBuilder().addAllMovies(movieService.findAll()).build()
            responseObserver?.onNext(response)
            responseObserver?.onCompleted()
        } catch (e: Exception) {
            println(e.message)
            responseObserver?.onError(e)
        }
    }
}