package com.gorlah.microb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MicroBApplication

fun main(args: Array<String>) {
	runApplication<MicroBApplication>(*args)
}
