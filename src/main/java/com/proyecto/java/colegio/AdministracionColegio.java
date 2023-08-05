package com.proyecto.java.colegio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdministracionColegio {

	public static void main(String[] args) {
		SpringApplication.run(AdministracionColegio.class, args);
		//Para encender el server desde una terminal bash
		//sh mvnw spring-boot:run
	}

}
