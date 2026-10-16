package com.ninad.ticketing_api.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.ninad.ticketing_api.model.Event;

import jakarta.annotation.PostConstruct;

@Repository
public class EventRepository {
	private final Map<Long,Event> Store = new ConcurrentHashMap<>();
	private final AtomicLong idCounter = new AtomicLong();
	
	public List<Event> findAll(){
		return new ArrayList<>(Store.values());
		
	}
	
	public Optional<Event> findById(Long id){
		return Optional.ofNullable(Store.get(id));
	}
	
	public Event save(Event event) {
		Long id = (event.getId() ==null)
				? idCounter.incrementAndGet()
				: event.getId();
		
		Event saved = new Event(id, event.getName(), event.getVenue(),
								event.getDateTime(), event.getPrice());
		
		Store.put(id,saved);
		return saved;
	}
	
	@PostConstruct
	public void seed() {
	    save(new Event(null, "Coldplay", "MetLife Stadium",
	            LocalDateTime.of(2026, 7, 14, 19, 30), new BigDecimal("149.99")));
	    save(new Event(null, "Knicks vs Celtics", "Madison Square Garden",
	            LocalDateTime.of(2026, 3, 2, 20, 0), new BigDecimal("89.50")));
	}

}
