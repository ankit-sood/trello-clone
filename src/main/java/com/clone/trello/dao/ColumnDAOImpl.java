package com.clone.trello.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.clone.trello.config.DBConfig;
import com.clone.trello.model.Column;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class ColumnDAOImpl implements ColumnDAO{
	@Autowired
	private final DBConfig dbConfig;
	
	@Autowired
	private final MongoTemplate mongoTemplate;
	
	@Override
	public List<Column> findRecordsEqualToValue(String key, String value) {
		Query query= new Query();
		query.addCriteria(Criteria.where(key).is(value));
		return mongoTemplate.find(query, Column.class, dbConfig.getColumnCollectionName());
	}

	@Override
	public List<Column> findRecordsGreaterThanValue(String key, Long value) {
		//Unimplemented Method
		return null;
	}
	
	@Override
	public boolean clearCollection() {
		mongoTemplate.remove(new Query(),dbConfig.getColumnCollectionName());
		return true;
	}

}
