package com.clone.trello.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.clone.trello.config.DBConfig;
import com.clone.trello.model.User;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private final DBConfig dbConfig;
	
	@Autowired
	private final MongoTemplate mongoTemplate;
	
	@Override
	public List<User> findRecordsEqualToValue(String key, String value) {
		Query query= new Query();
		query.addCriteria(Criteria.where(key).is(value));
		return mongoTemplate.find(query, User.class, dbConfig.getUserCollectionName());
	}

	@Override
	public List<User> findRecordsGreaterThanValue(String key, Long value) {
		//Unimplemented Method
		return null;
	}
	
	@Override
	public boolean clearCollection() {
		mongoTemplate.remove(new Query(),dbConfig.getUserCollectionName());
		return true;
	}

	@Override
	public Optional<User> createCard(User user) {
		try {
			return Optional.of(mongoTemplate.insert(user, dbConfig.getUserCollectionName()));
		} catch(Exception exp) {
			log.error("Exception occurred while inserting {}. {}", user, exp);
		}
		return Optional.empty();
	}

}
