package com.clone.trello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clone.trello.model.Card;

@RestController("/trello/cards")
public class CardsController {
	
	@PostMapping
	public void createCard(@RequestBody Card card) {
		
	}
	
	@GetMapping
	public void findByTag(@RequestAttribute("tag") String tag) {
		
	}

	@GetMapping
	public void findByColumn(@RequestAttribute("column") String column) {
		
	}
	
	@GetMapping
	public void findByUser(@RequestAttribute("user") String user) {
		
	}
	
	@GetMapping
	public void findAfterTimestamp(@RequestAttribute("timestamp") Long timestamp) {
		
	}
}
