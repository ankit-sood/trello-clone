package com.clone.trello.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeansConfig {
	
	@Bean("executor")
	public ExecutorService getExecutor() {
		return Executors.newFixedThreadPool(10);
	}
}
