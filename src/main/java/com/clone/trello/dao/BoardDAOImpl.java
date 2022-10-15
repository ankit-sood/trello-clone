package com.clone.trello.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.clone.trello.config.DBConfig;
import com.clone.trello.model.Board;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private final DBConfig dbConfig;
	
	@Autowired
	private final MongoTemplate mongoTemplate;
	
	@Override
	public List<Board> findRecordsEqualToValue(String key, String value) {
		Query query= new Query();
		query.addCriteria(Criteria.where(key).is(value));
		return mongoTemplate.find(query, Board.class, dbConfig.getBoardCollectionName());
	}

	@Override
	public List<Board> findRecordsGreaterThanValue(String key, Long value) {
		//Unimplemented Method
		return null;
	}

	@Override
	public boolean clearCollection() {
		mongoTemplate.remove(new Query(),dbConfig.getBoardCollectionName());
		return true;
	}

}
