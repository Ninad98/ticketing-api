package com.ninad.ticketing_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ninad.ticketing_api.exception.EventNotFoundException;
import com.ninad.ticketing_api.model.Event;
import com.ninad.ticketing_api.repository.EventRepository;

@Service
public class EventService {
	private final EventRepository repository;
	
	public EventService(EventRepository repository) {
		this.repository=repository;
	}
	
	public List<Event> findAll(){
		return repository.findAll();
	}
	
	public Event findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EventNotFoundException(id));
	}
		
}
