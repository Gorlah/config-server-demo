package com.gorlah.microservice

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.PostConstruct
import kotlin.reflect.KClass

@SpringBootApplication
class MicroserviceApplication

fun main(args: Array<String>) {
	runApplication<MicroserviceApplication>(*args)
}

@Component
class Test(@Value("\${property}") private val property: String) {

	private val logger = logger(Test::class)

	@PostConstruct
	fun postConstruct() {
		logger.info(property)
	}
}

@RestController
class Controller {

	@GetMapping("/hello")
	fun hello() = "hello'"
}

fun <T : Any> logger(kClass: KClass<T>) = LoggerFactory.getLogger(kClass.java)!!
