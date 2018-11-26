package com.bookapp.webclient.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data //includes getter and setter
@NoArgsConstructor
@ToString
public class Book {
	private String title;
	private Integer bookId;
	private String author;
	private Double price;
	private String category;
	
		
}
