package com.gorlah.user.server.property

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RefreshScope
@RestController
class PropertyController(@Value("\${myproperty}") private val myproperty: String) {

    @GetMapping("/myproperty")
    fun myproperty() = myproperty
}