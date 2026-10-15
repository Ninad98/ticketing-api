package com.ninad.ticketing_api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {
	
	@GetMapping
	public List<String> getAllEvents(){
		return List.of("ColdPlay at Metlife", "Knicks vs Celtics", "Hamilton");
	}
	

}
