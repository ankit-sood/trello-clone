package com.clone.trello.dao;

import java.util.List;
import java.util.Optional;

import com.clone.trello.model.Card;

public interface CardsDAO {
	Optional<Card> createCard(Card card);
	
	public List<Card> findRecordsEqualToValue(String key, String value);
	
	public List<Card> findRecordsGreaterThanValue(String key, Long value);
}
