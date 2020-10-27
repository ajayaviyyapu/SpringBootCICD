package com.ajayexamples.springbootcicd.api.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.ajayexamples.springbootcicd.api.entities.ThemeParkRide;
import com.ajayexamples.springbootcicd.api.repositories.ThemeParkRepository;

@RestController
public class ThemeParkRideController {
	
	// Best practice instead of Autowiring Doing a Constructor Injection.
	private final ThemeParkRepository themeParkRepo;

	public ThemeParkRideController(ThemeParkRepository themeParkRepo) {
		this.themeParkRepo = themeParkRepo;
	}
	
	@GetMapping(value = "/ride", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<ThemeParkRide> getRides(){
		return themeParkRepo.findAll();
	}
    
	@GetMapping(value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ThemeParkRide getRide(@PathVariable long id) {
		return themeParkRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Invalid ride id %s",id)));
	}
	
	@PostMapping(value = "/ride",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ThemeParkRide createRide(@Valid @RequestBody ThemeParkRide themeParkRide) {
		// @Valid checks whether the required validations are met based on the 
		// validation annotations we have defined in the Entity Class.
		return themeParkRepo.save(themeParkRide);
	}
	
	
	
	

}
