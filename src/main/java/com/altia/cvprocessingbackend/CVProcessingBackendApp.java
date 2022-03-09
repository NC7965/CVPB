package com.altia.cvprocessingbackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(
    servers = {
        @Server(url = "http://localhost:8085", description = "Default Server URL")
    }
)
public class CVProcessingBackendApp {

    public static void main(String[] args) {
        SpringApplication.run(CVProcessingBackendApp.class, args);
    }
}
