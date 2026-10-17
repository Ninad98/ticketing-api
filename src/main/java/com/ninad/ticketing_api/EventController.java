package com.ninad.ticketing_api;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninad.ticketing_api.dto.CreateEventRequest;
import com.ninad.ticketing_api.model.Event;
import com.ninad.ticketing_api.service.EventService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/events")
public class EventController {
	
	private final EventService service;
	
	public EventController(EventService service) {
		this.service = service;
	}
	@GetMapping
	public List<Event> getAllEvents(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Event getByID(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping()
	public ResponseEntity<Event> create(@Valid @RequestBody CreateEventRequest request){
		Event saved = service.create(request);
		URI Location = URI.create("/events/" + saved.getId());
		return ResponseEntity.created(Location).body(saved);
	}
	

}
