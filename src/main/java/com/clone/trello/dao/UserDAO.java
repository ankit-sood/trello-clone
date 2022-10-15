package com.clone.trello.dao;

import java.util.Optional;

import com.clone.trello.model.User;

public interface UserDAO extends BaseDAO<User>{
	public Optional<User> createCard(User user);
}
