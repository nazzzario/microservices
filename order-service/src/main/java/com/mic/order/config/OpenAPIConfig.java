package com.mic.order.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class OpenAPIConfig {


    @Bean
    public OpenAPI orderServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Order Service API")
                        .description("This is the REST API for Order Service")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0"))
                        .contact(new Contact()
                                .email("test@email.com")
                                .name("Nazar Krasnovoronka")))
                .servers(Collections.singletonList(new Server().url("http://localhost:8081")));
    }
}
