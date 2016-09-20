package com.ListProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"geppetto.module.bootsecurity.*","com.ListProject.*"})
@SpringBootApplication
public class ListProject extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ListProject.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(ListProject.class, args);
	}
}
