package com.ajayexamples.springbootcicd.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajayexamples.springbootcicd.api.entities.ThemeParkRide;

@Repository
public interface ThemeParkRepository extends JpaRepository<ThemeParkRide, Long>{
	
	List<ThemeParkRide> findByName(String name);

}
