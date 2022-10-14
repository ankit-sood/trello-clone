package com.clone.trello.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clone.trello.model.Card;

@RestController("/trello/cards")
public class CardsController {
	
	@PostMapping
	public void createCard(@RequestBody Card card) {
		
	}

}
