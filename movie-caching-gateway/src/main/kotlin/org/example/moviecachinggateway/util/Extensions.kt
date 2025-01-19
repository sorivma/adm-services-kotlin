package org.example.moviecachinggateway.util

import java.util.*

object Extensions {
    fun String.toUUID(): UUID = UUID.fromString(this)
}