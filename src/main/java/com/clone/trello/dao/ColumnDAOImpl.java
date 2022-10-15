package com.clone.trello.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.clone.trello.config.DBConfig;
import com.clone.trello.model.Column;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ColumnDAOImpl implements ColumnDAO{
	@Autowired
	private DBConfig dbConfig;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
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

	@Override
	public Optional<Column> createColumn(Column column) {
		try {
			return Optional.of(mongoTemplate.insert(column, dbConfig.getColumnCollectionName()));
		} catch(Exception exp) {
			log.error("Exception occurred while inserting {}. {}", column, exp);
		}
		return Optional.empty();
	}

}
