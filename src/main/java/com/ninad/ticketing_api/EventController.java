package com.ninad.ticketing_api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninad.ticketing_api.model.Event;
import com.ninad.ticketing_api.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	
	private final EventService service;
	
	public EventController(EventService service) {
		this.service = service;
	}
	@GetMapping
	public List<String> getAllEvents(){
		return List.of("ColdPlay at Metlife", "Knicks vs Celtics", "Hamilton");
	}
	
	@GetMapping("/{id}")
	public Event getByID(@PathVariable Long id) {
		return service.findById(id);
	}
	

}
