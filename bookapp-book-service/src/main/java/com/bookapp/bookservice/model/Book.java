package com.bookapp.bookservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter 
@Setter
@NoArgsConstructor
@ToString
public class Book {
	@Column(length=30)
	private String title;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="book_id")
	private Integer bookId;
	@Column(length=20)
	private String author;
	@Column(name="price")
	private Double price;
	@Column(length=20)
	private String category;
	
		
}
