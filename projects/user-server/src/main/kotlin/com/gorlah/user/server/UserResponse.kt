package com.gorlah.user.server

import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID

data class UserResponse(

    val id: UUID,

    @field:Schema(example = "gorlah")
    val username: String,
)
