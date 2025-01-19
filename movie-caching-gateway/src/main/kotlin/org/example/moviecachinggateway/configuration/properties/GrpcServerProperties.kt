package org.example.moviecachinggateway.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "grpc.client")
data class GrpcServerProperties(
    var host: String = "localhost",
    var port: Int = 50051,
)
