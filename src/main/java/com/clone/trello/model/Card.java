package com.clone.trello.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Card {
	@Id
    private Integer id;
	private List<String> labels; 
	private String column;
	private Long timestamp;
	private String user;
	private String board;
	private String tag;
	private String desc;
}
