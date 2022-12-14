package com.clone.trello.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Card {
	@Id
    private String id;
	
	private List<String> labels; 
	
	@NonNull
	private String columnId;
	
	@NonNull
	private Long timestamp;
	
	@NonNull
	private String userId;
	
	@NonNull
	private String boardId;
	
	@NonNull
	private String tag;
	
	@NonNull
	private String desc;
}
