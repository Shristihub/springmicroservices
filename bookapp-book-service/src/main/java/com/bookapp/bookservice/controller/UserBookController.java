package com.bookapp.bookservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.bookservice.model.Book;
import com.bookapp.bookservice.service.BookService;

@RestController
@RequestMapping("/users")
public class UserBookController {
	@Autowired
	BookService bookService;
	private static final Logger log = LoggerFactory.getLogger(UserBookController.class.getName());
	@GetMapping("/all-books")
	public List<Book> getAllBooks() {
		return bookService.findAllBooks();
	}

	@GetMapping("/books-by-author/{author}")
	public List<Book> findBooksByAuthor(@PathVariable("author") String author) {
		log.info("Book service - search by author");
		return bookService.findBooksByAuthor(author);
	}

	@GetMapping("/book-by-id/{bookId}")
	public Book findOneBook(@PathVariable("bookId") int bookId) {
		return bookService.findBookById(bookId);
	}

	@GetMapping("/books-by-category/{category}")
	public List<Book> findBooksByCategory(@PathVariable("category") String category) {
		List<Book> bookList = new ArrayList<>();
		bookList = bookService.findBooksByCategory(category);
		return bookList;
	}
}
