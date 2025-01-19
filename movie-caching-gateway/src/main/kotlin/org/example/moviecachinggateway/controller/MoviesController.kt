package org.example.moviecachinggateway.controller

import org.example.moviecachinggateway.dto.AsyncTaskResponseDto
import org.example.moviecachinggateway.dto.MovieDto
import org.example.moviecachinggateway.sevice.AsyncOperationService
import org.example.moviecachinggateway.sevice.GetMoviesService
import org.example.moviecachinggateway.sevice.metrics.MetricService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/movies")
class MoviesController(
    private val getMoviesService: GetMoviesService,
    private val asyncOperationService: AsyncOperationService,
    private val metricService: MetricService
) {
    @PostMapping
    fun create(@RequestBody @Validated movie: MovieDto): ResponseEntity<AsyncTaskResponseDto> {
        asyncOperationService.postMovie(movie)
        metricService.incrementHttpRequestCount()
        return ResponseEntity(
            AsyncTaskResponseDto.postDefault(),
            HttpStatus.ACCEPTED
        )
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<AsyncTaskResponseDto> {
        asyncOperationService.deleteMovie(id)
        metricService.incrementHttpRequestCount()
        return ResponseEntity(
            AsyncTaskResponseDto.deleteDefault(),
            HttpStatus.ACCEPTED
        )
    }

    @PutMapping
    fun update(@RequestBody @Validated movie: MovieDto): ResponseEntity<AsyncTaskResponseDto> {
        asyncOperationService.updateMovie(movie)
        metricService.incrementHttpRequestCount()
        return ResponseEntity(
            AsyncTaskResponseDto.putDefault(),
            HttpStatus.ACCEPTED
        )
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<MovieDto>> {
        metricService.incrementHttpRequestCount()
        return ResponseEntity(
            getMoviesService.getMovies(),
            HttpStatus.OK
        )
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<MovieDto> {
        metricService.incrementHttpRequestCount()
        return ResponseEntity(
            getMoviesService.getMovie(id),
            HttpStatus.OK,
        )
    }
}