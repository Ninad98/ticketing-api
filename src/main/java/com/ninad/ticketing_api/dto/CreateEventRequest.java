package com.ninad.ticketing_api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateEventRequest(

		@NotBlank(message = "Event name is required")
		String name,
		
		@NotBlank(message = "Event venue is required")
		String venue,
		
		@NotNull(message = "Event Date is required")
		@Future(message = "Event date must be in the future")
		LocalDateTime dateTime,
		
		@NotNull(message = "Price is required")
		@Positive(message = "Price must be greater than zero")
		BigDecimal price
		
		
			
		
		) {}
	
			
			
			
