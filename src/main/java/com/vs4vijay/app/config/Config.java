package com.vs4vijay.app.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("App API")
                .description("App API Specification")
                .version("v0.0.1")
                .license(new License().name("MIT")));
    }
}
