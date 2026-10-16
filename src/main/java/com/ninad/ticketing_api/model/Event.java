package com.ninad.ticketing_api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Event {
	
	private Long id;
	private String name;
	private String venue;
	private LocalDateTime dateTime;
	private BigDecimal price;
	
	public Event(Long id, String name, String venue, LocalDateTime dateTime, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.venue = venue;
		this.dateTime = dateTime;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public String getVenue() {
		return venue;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", venue=" + venue + ", dateTime=" + dateTime + ", price=" + price
				+ "]";
	}	
	

}
