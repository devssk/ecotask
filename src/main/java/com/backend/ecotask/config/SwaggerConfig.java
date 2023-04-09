package com.backend.ecotask.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "ecotask",
                description = "API 명세서"
        )
)

@Configuration
public class SwaggerConfig {
}
