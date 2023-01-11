package br.rpe.peopleregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.rpe.peopleregistration.model.entity.Client;

@SpringBootApplication
public class PeopleRegistrationApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(PeopleRegistrationApplication.class, args);
		
	}

}
