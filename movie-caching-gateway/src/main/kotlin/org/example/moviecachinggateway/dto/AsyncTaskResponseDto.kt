package org.example.moviecachinggateway.dto

data class AsyncTaskResponseDto(
    val type: Type,
    val message: String
) {
    enum class Type {
        POST,
        PUT,
        DELETE
    }

    companion object {
        fun postDefault(): AsyncTaskResponseDto {
            return AsyncTaskResponseDto(
                type = Type.POST,
                message = "Create movie task registered"
            )
        }

        fun putDefault(): AsyncTaskResponseDto {
            return AsyncTaskResponseDto(
                type = Type.PUT,
                message = "Create movie task registered"
            )
        }

        fun deleteDefault(): AsyncTaskResponseDto {
            return AsyncTaskResponseDto(
                type = Type.DELETE,
                message = "Delete movie task registered"
            )
        }
    }
}
