package configuration

import io.grpc.Server
import io.grpc.ServerBuilder
import service.crud.impl.MovieServiceImpl
import service.grpc.GrpcMovieServiceImpl

object GrpcConfig {
    private const val GRPC_PORT: Int = 9191

    fun init() {
        val server: Server = ServerBuilder.forPort(GRPC_PORT)
            .addService(GrpcMovieServiceImpl(MovieServiceImpl()))
            .build()

        println("Starting gRPC server on port $GRPC_PORT")
        server.start()
        println("Server started on port $GRPC_PORT")


        Runtime.getRuntime().addShutdownHook(Thread {
            println("Shutting down gRPC server...")
            server.shutdown()
        })

        server.awaitTermination()
    }
}