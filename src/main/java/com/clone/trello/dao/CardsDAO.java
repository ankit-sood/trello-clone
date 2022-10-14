package com.clone.trello.dao;

import java.util.List;

import com.clone.trello.model.Card;

public interface CardsDAO {
	boolean createCard(Card card);
	
	public List<Card> findRecordsEqualToValue(String key, String value);
	
	public List<Card> findRecordsGreaterThanValue(String key, Long value);
}
