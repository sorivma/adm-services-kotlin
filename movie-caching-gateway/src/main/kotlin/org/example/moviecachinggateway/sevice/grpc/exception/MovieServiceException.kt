package org.example.moviecachinggateway.sevice.grpc.exception

class MovieServiceException(override val message: String?): RuntimeException(message)