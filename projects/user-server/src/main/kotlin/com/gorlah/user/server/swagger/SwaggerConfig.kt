package com.gorlah.user.server.swagger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfig {

    @Bean
    fun swagger() = Docket(DocumentationType.OAS_30)
        .select()
        .paths { !it.matches(Regex("/error")) }
        .build()!!
}
