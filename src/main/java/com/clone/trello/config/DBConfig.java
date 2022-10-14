package com.clone.trello.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;


@Data
@Configuration
public class DBConfig {
	@Value("${mongodb.collection-name: trello}")
	public String collectionName;
}
