package com.gorlah.user.server

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

    @PostMapping
    fun createUser(@Valid @RequestBody createUserRequest: CreateUserRequest) =
        userService.createUser(createUserRequest)
}