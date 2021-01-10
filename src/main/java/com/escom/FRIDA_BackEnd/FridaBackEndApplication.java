package com.escom.FRIDA_BackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }, scanBasePackages = {"com.escom.FRIDA_BackEnd", "com.escom.FRIDA_BackEnd.Entity",
"com.escom.FRIDA_BackEnd.Repository", "com.escom.FRIDA_BackEnd.Controller", "com.escom.FRIDA_BackEnd.Service",
"com.escom.FRIDA_BackEnd.Security", "com.escom.FRIDA_BackEnd.Security.JWT", "com.escom.FRIDA_BackEnd.DTO",
"com.escom.FRIDA_BackEnd.enums"})
public class FridaBackEndApplication {

	public static void main(String[] args) {
            SpringApplication.run(FridaBackEndApplication.class, args);
	}

        @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
                            registry.addMapping("/localhost:4200/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");;                                
			}
		};
	}
}
