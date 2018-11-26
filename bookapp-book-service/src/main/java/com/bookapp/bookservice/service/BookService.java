package com.bookapp.bookservice.service;

import java.util.List;

import com.bookapp.bookservice.model.Book;

public interface BookService {
	void addBook(Book book);
	Book findBookById(int bookId);
	List<Book> findBooksByAuthor(String author);
	List<Book> findAllBooks();
	void deleteBook(int bookId);
	public List<Book> findBooksByCategory(String category);
	public void updateBook(Book book);
	
}
