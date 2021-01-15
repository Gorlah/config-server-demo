package com.gorlah.microservice

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@SpringBootApplication
class MicroserviceApplication

fun main(args: Array<String>) {
	runApplication<MicroserviceApplication>(*args)
}

@Component
class Test(
	@Value("\${property}") private val property: String?,
) {

	@PostConstruct
	fun postConstruct() {
		println(property)
	}
}
