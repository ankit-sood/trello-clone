package com.clone.trello.dao;

import java.util.Optional;

import com.clone.trello.model.Board;

public interface BoardDAO extends BaseDAO<Board>{
	public Optional<Board> createBoard(Board board);
}
