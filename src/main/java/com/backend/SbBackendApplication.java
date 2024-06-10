package com.backend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "Employee Management App", version = "1.0", description = "Spring Boot with Vue JS"),
		servers = @Server(description = "Tomcat 9", url = "http://localhost:8080"))
public class SbBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbBackendApplication.class, args);
	}
}