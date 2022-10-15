package com.clone.trello.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clone.trello.model.Card;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CardValidationService {
	@Autowired
	public final ExecutorService executor;
	
	
	public boolean validate(Card card) {
		List<Callable<Boolean>> callableTasks = new ArrayList<>();
		callableTasks.add(validateUserTask(1L));
		return false;
	}

	private Callable<Boolean> validateUserTask(Long userId){
		return () -> {
			return false;
		};
	}
	
}
