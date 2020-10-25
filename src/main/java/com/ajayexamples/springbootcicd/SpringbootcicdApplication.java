package com.ajayexamples.springbootcicd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ajayexamples.springbootcicd.api.entities.ThemeParkRide;
import com.ajayexamples.springbootcicd.api.repositories.ThemeParkRepository;

@SpringBootApplication
public class SpringbootcicdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcicdApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner sampleData(ThemeParkRepository themeParkRepo) {
		return (args) -> {
			themeParkRepo.save(new ThemeParkRide("Roller Coaster", "Train Ride", 3, 4));
			themeParkRepo.save(new ThemeParkRide("Boat Coaster", "Boat Ride", 2, 3));
			themeParkRepo.save(new ThemeParkRide("Aero Coaster", "Aeroplane Ride", 5, 2));
		};
				
	}
	

}
