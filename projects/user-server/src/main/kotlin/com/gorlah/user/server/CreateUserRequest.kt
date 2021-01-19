package com.gorlah.user.server

import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotEmpty

data class CreateUserRequest(

    @field:Schema(example = "gorlah")
    @field:NotEmpty
    val username: String?,

    @field:Schema(example = "mypassword")
    @field:NotEmpty
    val password: String?,
)
