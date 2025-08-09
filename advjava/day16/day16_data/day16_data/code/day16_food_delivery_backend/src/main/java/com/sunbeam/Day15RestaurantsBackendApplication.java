package com.sunbeam;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication//config class
public class Day15RestaurantsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day15RestaurantsBackendApplication.class, args);
	}
	//2. Configure ModelMapper as a spring bean - 
	//so that SC can manage its life cycle n 
	//can be used for D.I , in other spring beans.
	@Bean
	 ModelMapper modelMapper() {
		System.out.println("in model mapper creation");
		ModelMapper mapper=   new ModelMapper();
		//configure model mapper
		//3. set matching strategy - STRICT - 
		//to transfer only matching (by name )src props -> dest props
		mapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.STRICT)
		//4. do not transfer null values from src -> dest
		.setPropertyCondition(Conditions.isNotNull());		
		return mapper;
	}

}
