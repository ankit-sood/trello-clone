package com.clone.trello.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.clone.trello.config.DBConfig;
import com.clone.trello.model.Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private DBConfig dbConfig;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
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

	@Override
	public Optional<Board> createBoard(Board board) {
		try {
			return Optional.of(mongoTemplate.insert(board, dbConfig.getBoardCollectionName()));
		} catch(Exception exp) {
			log.error("Exception occurred while inserting {}. {}", board, exp);
		}
		return Optional.empty();
	}

}
