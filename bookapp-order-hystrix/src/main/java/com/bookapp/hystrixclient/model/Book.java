package com.bookapp.hystrixclient.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@NoArgsConstructor
@ToString
public class Book {
	private String title;
	private Integer bookId;
	private String author;
	private Double price;
	private String category;
	public Book(String title, String author, Double price, String category) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.category = category;
	}
	
		
}
