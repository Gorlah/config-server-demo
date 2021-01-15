package com.gorlah.microa

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@SpringBootApplication
class MicroAApplication

fun main(args: Array<String>) {
	runApplication<MicroAApplication>(*args)
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
