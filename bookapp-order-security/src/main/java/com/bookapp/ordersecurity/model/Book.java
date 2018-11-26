package com.bookapp.ordersecurity.model;

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
	
		
}
