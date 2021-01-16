package com.gorlah.configserver

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct
import kotlin.reflect.KClass

@EnableConfigServer
@SpringBootApplication
class ConfigServerApplication

fun main(args: Array<String>) {
    runApplication<ConfigServerApplication>(*args)
}

@Component
class Test(@Value("\${property}") private val property: String) {

    private val logger = logger(Test::class)

    @PostConstruct
    fun postConstruct() {
        logger.info(property)
    }
}

fun <T : Any> logger(kClass: KClass<T>) = LoggerFactory.getLogger(kClass::class.java)!!