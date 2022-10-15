package com.clone.trello.dao;

import java.util.Optional;

import com.clone.trello.model.Card;

public interface CardsDAO extends BaseDAO<Card>{
	Optional<Card> createCard(Card card);
	
}
