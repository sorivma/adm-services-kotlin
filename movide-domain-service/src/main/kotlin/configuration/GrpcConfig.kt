package configuration

object Config {
    val grpcPort: Int = System.getenv("GRPC_SERVER_PORT").toIntOrNull() ?: 9080
    val dbUrl: String = System.getenv("DB_URL") ?: "jdbc:postgresql://localhost:5432/movies_db"
    val dbUser: String = System.getenv("DB_USER") ?: "postgres"
    val dbPassword: String = System.getenv("DB_PASSWORD") ?: "postgres"
}