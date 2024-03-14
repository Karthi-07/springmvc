package com.example.springmvc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringmvcApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	}
}
