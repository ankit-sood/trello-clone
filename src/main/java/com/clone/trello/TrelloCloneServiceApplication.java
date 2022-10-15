package com.clone.trello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.clone.trello.dao.BoardDAO;
import com.clone.trello.dao.CardsDAO;
import com.clone.trello.dao.ColumnDAO;
import com.clone.trello.dao.UserDAO;
import com.clone.trello.model.Board;
import com.clone.trello.model.Column;
import com.clone.trello.model.User;

@SpringBootApplication
public class TrelloCloneServiceApplication implements CommandLineRunner{
	@Autowired
	public UserDAO userDAO;
	
	@Autowired
	public BoardDAO boardDAO;
	
	@Autowired
	public ColumnDAO columnDAO;
	
	@Autowired
	public CardsDAO cardDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(TrelloCloneServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//clear all the collections
		cardDAO.clearCollection();
		columnDAO.clearCollection();
		boardDAO.clearCollection();
		userDAO.clearCollection();
		
		//insert values
		userDAO.createUser(getUser());
		boardDAO.createBoard(getBoard());
		getAllColumns().stream().forEach(col -> columnDAO.createColumn(col));
	}
	
	private User getUser() {
		User user = new User();
		user.setName("Ankit Sood");
		user.setDesignation("Senior Engineer");
		user.setId("a0s227");
		return user;
	}
	
	private Board getBoard() {
		Board board = new Board();
		board.setName("Team-Justice");
		board.setDesc("Board created for the needs for justice.");
		board.setId("b227");
		return board;
	}
	
	private List<Column> getAllColumns(){
		List<Column> columns = new ArrayList<>();
		Column column1 = new Column();
		column1.setId("c1-todo");
		column1.setName("TODO");
		columns.add(column1);
		
		Column column2 = new Column();
		column2.setId("c1-progress");
		column2.setName("IN-PROGRESS");
		columns.add(column2);
		
		Column column3 = new Column();
		column2.setId("c3-done");
		column2.setName("DONE");
		columns.add(column3);
		return columns;
	}
}
