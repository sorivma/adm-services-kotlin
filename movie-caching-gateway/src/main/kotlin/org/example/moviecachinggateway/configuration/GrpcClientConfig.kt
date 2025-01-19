package org.example.moviecachinggateway.configuration

import com.example.movie.MovieServiceGrpc
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import org.example.moviecachinggateway.configuration.properties.GrpcServerProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GrpcClientConfig(private val grpcServerProperties: GrpcServerProperties) {
    @Bean
    fun managedChannel(): ManagedChannel {
        return ManagedChannelBuilder
            .forAddress(grpcServerProperties.host, grpcServerProperties.port)
            .usePlaintext()
            .build()
    }

    @Bean
    fun movieServiceStub(): MovieServiceGrpc.MovieServiceBlockingStub {
        return MovieServiceGrpc.newBlockingStub(managedChannel())
    }
}