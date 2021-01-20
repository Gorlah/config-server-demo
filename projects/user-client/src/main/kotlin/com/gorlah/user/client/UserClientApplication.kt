package com.gorlah.user.client

import com.github.javafaker.Faker
import com.gorlah.commons.logger
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PostMapping

@EnableScheduling
@EnableFeignClients
@SpringBootApplication
class UserClientApplication

fun main(args: Array<String>) {
	runApplication<UserClientApplication>(*args)
}

@Component
class UserGenerator(private val userClient: UserClient) {

	private val logger = logger(UserGenerator::class)
	private val faker = Faker()

	@Scheduled(fixedDelay = 100)
	fun createUser() = logger.info(
		userClient.createUser(
			CreateUserRequest(
				username = faker.name().username(),
				password = faker.internet().password()
			)
		)
	)
}

data class CreateUserRequest(val username: String?, val password: String)

@FeignClient(name = "user-client", url = "http://localhost:8080")
interface UserClient {

	@PostMapping("/users")
	fun createUser(createUserRequest: CreateUserRequest): String
}
