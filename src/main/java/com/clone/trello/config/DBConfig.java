package com.clone.trello.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DBConfig {
	@Value("${mongodb.cards.collection-name: trello}")
	public String cardsCollectionName;
	
	@Value("${mongodb.user.collection-name: trello}")
	public String userCollectionName;
	
	@Value("${mongodb.column.collection-name: trello}")
	public String columnCollectionName;
	
	@Value("${mongodb.board.collection-name: trello}")
	public String boardCollectionName;

	public String getCardsCollectionName() {
		return cardsCollectionName;
	}

	public String getUserCollectionName() {
		return userCollectionName;
	}

	public String getColumnCollectionName() {
		return columnCollectionName;
	}

	public String getBoardCollectionName() {
		return boardCollectionName;
	}
}
