package dev.wakandaacademy.clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@SpringBootApplication
public class ClinicaMedicaApplication {

	@GetMapping
	public String getHome() {
		return "Clinica Medica - API Home";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ClinicaMedicaApplication.class, args);
	}
}
