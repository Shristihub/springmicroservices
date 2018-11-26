package com.bookapp.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.bookservice.model.Book;
import com.bookapp.bookservice.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	public BookRepository bookRepository;

	@Override
	public void addBook(Book book) {
		bookRepository.save(book);
	}
	@Override
	public Book findBookById(int bookId) {
		return bookRepository.findById(bookId).get();
	}

	@Override
	public List<Book> findBooksByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	@Override
	public List<Book> findBooksByCategory(String category) {
		return bookRepository.findByCategory(category);
	}

	@Override
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public void updateBook(Book book) {

	}

	@Override
	public void deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
	}

}
