package com.clone.trello.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clone.trello.dao.BoardDAO;
import com.clone.trello.dao.ColumnDAO;
import com.clone.trello.dao.UserDAO;
import com.clone.trello.model.Board;
import com.clone.trello.model.Card;
import com.clone.trello.model.Column;
import com.clone.trello.model.User;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Component
public class CardValidationService {
	@Autowired
	public final ExecutorService executorService;
	
	@Autowired
	public final UserDAO userDAO;
	
	@Autowired
	public final BoardDAO boardDAO;
	
	@Autowired
	public final ColumnDAO columnDAO;
	
	
	public boolean validate(Card card) {
		boolean isValid = false;
		try {
			List<Callable<Boolean>> callableTasks = getAllValidationTasks(card);
			List<Future<Boolean>> futures = executorService.invokeAll(callableTasks);
			isValid = futures.stream().map(getResult())
									  .reduce(true, (result, subResult) -> result && subResult);
		} catch (InterruptedException e) {
			log.error("Validations interrupted");
		}
		
		return isValid;
	}
	
	private List<Callable<Boolean>> getAllValidationTasks(Card card) {
		List<Callable<Boolean>> callableTasks = new ArrayList<>();
		callableTasks.add(validateUserTask(card.getUserId()));
		callableTasks.add(validateColumnTask(card.getColumnId()));
		callableTasks.add(validateBoardTask(card.getBoardId()));
		return callableTasks;
	}
	
	private Function<Future<Boolean>, Boolean> getResult(){
		return x -> {
			boolean isValid = false;
			try {
				isValid = x.get();
			} catch (InterruptedException | ExecutionException e) {
				log.error("Exception Occured while processing, {}", e);
			}
			return isValid;
		};
	} 

	private Callable<Boolean> validateUserTask(String userId){
		return () -> {
			List<User> users = userDAO.findRecordsEqualToValue("_id", userId);
			return users != null && users.size() !=0 ? true : false;
		};
	}
	
	private Callable<Boolean> validateColumnTask(String colId){
		return () -> {
			List<Column> cols = columnDAO.findRecordsEqualToValue("_id", colId);
			return cols != null && cols.size() !=0 ? true : false;
		};
	}
	
	private Callable<Boolean> validateBoardTask(String boardId){
		return () -> {
			List<Board> boards = boardDAO.findRecordsEqualToValue("_id", boardId);
			return boards != null && boards.size() !=0 ? true : false;
		};
	}
	
}
