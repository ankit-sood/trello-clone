package com.clone.trello.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

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
	
	public Optional<Card> createCard(Card card) {
		card.setId(UUID.randomUUID().toString());
		return cardsDAO.createCard(card);
	}
	
	public List<Card> findRecordsByAttribute(Map<String, String> map){
		if(map.get("tag")!=null) {
			return findRecordsByKeyValue("tag", map.get("tag"));
		} else if(map.get("column")!=null) {
			return findRecordsByKeyValue("column", map.get("column"));
		} else if(map.get("user")!=null) {
			return findRecordsByKeyValue("user", map.get("user"));
		} else if(map.get("timestamp")!=null) {
			try {
				return findRecordsByKeyValue("timestamp", Long.valueOf(map.get("timestamp")));
			} catch(NumberFormatException exp) {
				return new ArrayList<>();
			}
		} else {
			return new ArrayList<>();
		}
	}
	
	private List<Card> findRecordsByKeyValue(String key, String value) {
		return cardsDAO.findRecordsEqualToValue(key, value);
	}
	
	private List<Card> findRecordsByKeyValue(String key, Long value) {
		return cardsDAO.findRecordsGreaterThanValue(key, value);
	}
}
