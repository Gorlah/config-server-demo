package com.gorlah.commons.boot

import com.gorlah.commons.kotlin.logger
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class HelloComponent : ApplicationListener<ContextRefreshedEvent> {

    private val logger = logger(HelloComponent::class)

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        logger.info("***** Hello from HelloComponent!")
    }
}
