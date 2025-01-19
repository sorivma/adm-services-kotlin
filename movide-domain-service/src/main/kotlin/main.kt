import configuration.DataBaseConfig
import configuration.GrpcConfig
import configuration.RmqConfiguration
import kotlin.system.exitProcess

fun main() {
    retryConnection {
        println("Connecting DB")
        DataBaseConfig.init()
    }
    retryConnection {
        println("Connecting RMQ")
        RmqConfiguration.init()
    }
    GrpcConfig.init()
}

fun <T> retryConnection(
    connectionLogic: () -> T
): T {
    val maxRetries = 5
    val delayMillis = 5000L

    repeat(maxRetries) { attempt ->
        println("Attempting to connect Attempt ${attempt + 1}")
        try {
            return connectionLogic()
        } catch (e: Exception) {
            println("Attempt ${attempt + 1} failed: ${e.message}")
            if (attempt < maxRetries - 1) {
                Thread.sleep(delayMillis)
            } else {
                println("Max retries reached. Exiting.")
                exitProcess(1)
            }
        }
    }
    error("Unreachable code")
}