package configuration

import Extensions.toUUID
import com.example.movie.Movie
import com.google.protobuf.InvalidProtocolBufferException
import com.rabbitmq.client.CancelCallback
import com.rabbitmq.client.ConnectionFactory
import com.rabbitmq.client.DeliverCallback
import service.crud.MovieService
import service.crud.impl.MovieServiceImpl

object RmqConfiguration {
    private val host = System.getenv("RMQ_HOST") ?: "localhost"
    private val port = System.getenv("RMQ_PORT")?.toInt() ?: 5672
    private val username = System.getenv("RMQ_USERNAME") ?: "sorivma"
    private val password = System.getenv("RMQ_PASSWORD") ?: "sorivma"
    private val movieService: MovieService = MovieServiceImpl()

    private const val POST_Q = "movies_post_queue"
    private const val UPDATE_Q = "movies_update_queue"
    private const val DELETE_Q = "movies_delete_queue"

    fun init() {
        try {
            val factory = ConnectionFactory()
            factory.host = host
            factory.port = port
            factory.username = username
            factory.password = password

            val connection = factory.newConnection()
            val channel = connection.createChannel()


            val postCallback = DeliverCallback { _, delivery ->
                val messageBody = delivery.body

                try {
                    val movie = Movie.parseFrom(messageBody)
                    println("Recieved movie $movie")
                    movieService.createMovie(movie)
                } catch (e: InvalidProtocolBufferException) {
                    println("Failed to parse Protobuf message: ${e.message}")
                }
            }

            val updateCallback = DeliverCallback { _, delivery ->
                val messageBody = delivery.body

                try {
                    val movie = Movie.parseFrom(messageBody)
                    println("Recieved movie $movie")
                    movieService.updateMovie(movie)
                } catch (e: InvalidProtocolBufferException) {
                    println("Failed to parse Protobuf message: ${e.message}")
                }
            }

            val deleteCallback = DeliverCallback { _, delivery ->
                val messageBody = delivery.body

                try {
                    val uuidString = String(messageBody)
                    println("Recieved delete movie message $uuidString")
                    movieService.deleteMovie(uuidString.toUUID())
                } catch (e: InvalidProtocolBufferException) {
                    println("Failed to parse Protobuf message: ${e.message}")
                }
            }

            channel.basicConsume(POST_Q, true, postCallback, CancelCallback {})
            channel.basicConsume(UPDATE_Q, true, updateCallback, CancelCallback {})
            channel.basicConsume(DELETE_Q, true, deleteCallback, CancelCallback {})

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}