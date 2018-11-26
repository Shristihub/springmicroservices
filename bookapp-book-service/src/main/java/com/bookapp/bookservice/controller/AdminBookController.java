package com.bookapp.bookservice.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookapp.bookservice.model.Book;
import com.bookapp.bookservice.service.BookService;

@RestController
@RequestMapping("/admin")
public class AdminBookController {

	@Autowired
	BookService bookService;
	@PostMapping("/add-book")
	public ResponseEntity<Void> addBook(@RequestBody Book book) {
		System.out.println("hello");
		System.out.println(book);
		bookService.addBook(book);
		URI location= ServletUriComponentsBuilder
				.fromCurrentRequest().path(
						"/{bookId}").buildAndExpand(book.getBookId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@GetMapping("/delete-book/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookid) {
		bookService.deleteBook(bookid);
		
	}
	@PostMapping("/update-book")
	public void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
		
	}
}
