package com.clone.trello.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.clone.trello.config.DBConfig;
import com.clone.trello.model.Card;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Repository
public class CardsDAOImpl implements CardsDAO{
	@Autowired
	private final DBConfig dbConfig;
	
	@Autowired
	private final MongoTemplate mongoTemplate;
	
	@Override
	public Optional<Card> createCard(Card card) {
		try {
			return Optional.of(mongoTemplate.insert(card, dbConfig.getCardsCollectionName()));
		} catch(Exception exp) {
			log.error("Exception occurred while inserting {}. {}", card, exp);
		}
		return Optional.empty();
	}
	
	@Override
	public List<Card> findRecordsEqualToValue(String key, String value){
		Query query= new Query();
		query.addCriteria(Criteria.where(key).is(value));
		return mongoTemplate.find(query, Card.class, dbConfig.getCardsCollectionName());
	}
	
	@Override
	public List<Card> findRecordsGreaterThanValue(String key, Long value){
		Query query= new Query();
		query.addCriteria(Criteria.where(key).gt(value));
		return mongoTemplate.find(query, Card.class, dbConfig.getCardsCollectionName());
	}

}
