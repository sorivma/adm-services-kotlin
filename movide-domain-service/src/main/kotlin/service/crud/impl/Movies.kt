package service.crud.impl

import org.jetbrains.exposed.dao.id.UUIDTable

object Movies: UUIDTable() {
    val title = varchar("title", 50)
    val director = varchar("director", 50)
    val genre = varchar("genre", 50)
    val releaseYear = integer("release_year")
}
