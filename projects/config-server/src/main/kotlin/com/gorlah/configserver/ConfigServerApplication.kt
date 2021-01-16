package com.gorlah.configserver

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer
import kotlin.reflect.KClass

@EnableConfigServer
@SpringBootApplication
class ConfigServerApplication

fun main(args: Array<String>) {
    runApplication<ConfigServerApplication>(*args)
}

fun <T : Any> logger(kClass: KClass<T>) = LoggerFactory.getLogger(kClass::class.java)!!
