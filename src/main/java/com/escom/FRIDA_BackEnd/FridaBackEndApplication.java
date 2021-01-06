package com.escom.FRIDA_BackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.escom.FRIDA_BackEnd", "com.escom.FRIDA_BackEnd.Entity",
"com.escom.FRIDA_BackEnd.Repository", "com.escom.FRIDA_BackEnd.Controller", "com.escom.FRIDA_BackEnd.Service"})
public class FridaBackEndApplication {

	public static void main(String[] args) {
            SpringApplication.run(FridaBackEndApplication.class, args);
	}

}
