package configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Slf4jSqlDebugLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

object DataBaseConfig {
    private val dbUrl: String = System.getenv("DB_URL") ?: "jdbc:postgresql://localhost:5432/movies_db"
    private val dbUser: String = System.getenv("DB_USER") ?: "postgres"
    private val dbPassword: String = System.getenv("DB_PASSWORD") ?: "postgres"

    fun init() {
        val config = HikariConfig().apply {
            jdbcUrl = dbUrl
            username = dbUser
            password = dbPassword
            driverClassName = "org.postgresql.Driver"
            maximumPoolSize = 3
        }

        val dataSource = HikariDataSource(config)
        Database.connect(dataSource)

        transaction {
            this.addLogger(Slf4jSqlDebugLogger)
        }
    }
}