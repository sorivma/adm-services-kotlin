import java.util.*

object Extensions {
    fun String.toUUID(): UUID {
        return UUID.fromString(this)
    }
}