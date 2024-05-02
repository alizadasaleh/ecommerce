package com.ailab.ecommerce.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "api/v3/",version = "1.0",description = "test"))
public class SwaggerConfig {

}