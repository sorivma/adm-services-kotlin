package org.example.moviecachinggateway.controller.advice

import io.grpc.Status
import io.grpc.StatusRuntimeException
import org.example.moviecachinggateway.sevice.grpc.exception.MovieServiceException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {
    data class GrpcSpecificExceptionResponse(
        val statusCode: Status.Code,
        val statusDescription: String?,
        val message: String?
    )

    @ExceptionHandler(MovieServiceException::class)
    fun handleMovieServiceException(ex: MovieServiceException): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(StatusRuntimeException::class)
    fun handleStatusRuntimeException(ex: StatusRuntimeException): ResponseEntity<GrpcSpecificExceptionResponse> {
        return ResponseEntity(GrpcSpecificExceptionResponse(ex.status.code, ex.status.description, ex.message), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}