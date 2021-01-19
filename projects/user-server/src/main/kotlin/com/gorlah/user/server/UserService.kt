package com.gorlah.user.server

import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UserService(
    private val userRepository: UserRepository,
) {

    fun createUser(createUserRequest: CreateUserRequest) =
        userRepository.insert(
            User(
                id = UUID.randomUUID(),
                username = createUserRequest.username!!,
                password = createUserRequest.password!!,
            )
        ).let {
            UserResponse(
                id = it.id,
                username = it.username,
            )
        }
}