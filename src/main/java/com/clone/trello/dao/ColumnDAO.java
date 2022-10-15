package com.clone.trello.dao;

import java.util.Optional;

import com.clone.trello.model.Column;

public interface ColumnDAO extends BaseDAO<Column>{
	public Optional<Column> createColumn(Column column);
}
