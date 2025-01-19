package org.example.moviecachinggateway.sevice.rabbitmq

import com.example.movie.Movie
import org.example.moviecachinggateway.dto.MovieDto
import org.example.moviecachinggateway.dto.mapper.MovieMapper.toProto
import org.example.moviecachinggateway.sevice.AsyncOperationService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageProperties
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service
import java.util.*

@Service
class MovieProducer(private val rabbitTemplate: RabbitTemplate) : AsyncOperationService {
    private val moviesExchange = "movies_exchange"
    private val log: Logger = LoggerFactory.getLogger(MovieProducer::class.java)


    override fun updateMovie(movie: MovieDto) {
        rabbitTemplate.convertAndSend(moviesExchange, "movies.update", movie.toProto().toMessage())
        log.info("Update movie ${movie.id} added to queue")
    }

    override fun deleteMovie(id: UUID) {
        rabbitTemplate.convertAndSend(moviesExchange, "movies.delete", id.toString())
        log.info("Delete movie message with $id added to queue")
    }

    override fun postMovie(movie: MovieDto) {
        rabbitTemplate.convertAndSend(moviesExchange, "movies.post", movie.toProto().toMessage())
        log.info("Add movie request added to queue $movie")
    }

    companion object {
        fun Movie.toMessage(): Message =
            Message(this.toByteArray(), MessageProperties().apply { this.type = "application/x-protobuf" })
    }
}