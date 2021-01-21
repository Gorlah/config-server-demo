package com.gorlah.user.server.swagger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import java.util.function.Predicate

@Configuration
class SwaggerConfig {

    @Bean
    fun swagger() = Docket(DocumentationType.OAS_30)
        .select()
        .paths(Predicate.not(PathSelectors.ant("/error/**")))
        .build()!!
}
