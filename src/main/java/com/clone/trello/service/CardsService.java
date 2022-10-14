package com.clone.trello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.trello.dao.CardsDAO;
import com.clone.trello.model.Card;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CardsService {
	@Autowired
	private final CardsDAO cardsDAO;
	
	public boolean createCard(Card card) {
		return cardsDAO.createCard(card);
	}
	
	public List<Card> findRecordsByKeyValue(String key, String value) {
		return cardsDAO.findRecordsEqualToValue(key, value);
	}
	
	public List<Card> findRecordsByKeyValue(String key, Long value) {
		return cardsDAO.findRecordsGreaterThanValue(key, value);
	}
}
