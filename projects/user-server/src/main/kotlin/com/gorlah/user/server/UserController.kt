package com.gorlah.user.server

import com.gorlah.commons.kotlin.logger
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/users")
@RestController
class UserController(
    private val userService: UserService,
) {

    private val logger = logger(UserController::class)

    @PostMapping
    fun createUser(@Valid @RequestBody createUserRequest: CreateUserRequest): UserResponse {
        logger.info(createUserRequest.toString())
        return userService.createUser(createUserRequest)
    }
}
