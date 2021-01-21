package com.gorlah.user.server.property

import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RefreshScope
@RestController
@RequestMapping("/properties")
class PropertyController(
    private val environment: Environment,
) {

    @GetMapping("/{property}")
    fun getProperty(@PathVariable property: String) = environment.getProperty(property)
}
