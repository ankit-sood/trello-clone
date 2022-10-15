package com.clone.trello.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.clone.trello.model.Card;
import com.clone.trello.service.CardValidationService;
import com.clone.trello.service.CardsService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/trello/cards")
public class CardsController {
	
	@Autowired
	private final CardsService cardsService;
	
	@Autowired
	private final CardValidationService cardValidationService;
	
	@PostMapping
	public ResponseEntity<Card> createCard(@RequestBody Card card) {
		boolean isValid = cardValidationService.validate(card);
		if(isValid) {
			Optional<Card> cardOp = cardsService.createCard(card);
			String id = cardOp.isPresent() ? cardOp.get().getId() : "";
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		                .path("/"+id)
		                .buildAndExpand(id)
		                .toUri();
			
			return ResponseEntity.created(location).build(); 
		} else {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@GetMapping()
	public List<Card> findByAttribute(@RequestParam Map<String, String> map) {
		return cardsService.findRecordsByAttribute(map);
	}
	
}
