package com.gorlah.user.server.application

import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ApplicationController(
    private val discoveryClient: DiscoveryClient,
) {

    @RequestMapping("/applications/{application}")
    fun getApplications(@PathVariable application: String) = discoveryClient.getInstances(application)
}
