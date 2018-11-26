package com.bookapp.feignclient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.feignclient.model.Book;
import com.bookapp.feignclient.service.IFeignClient;


@RestController
@RequestMapping("/feign-service")
public class FeignController {
	@Autowired
	private IFeignClient feignClient;
	@GetMapping(value = "/find-author/{author}", produces = "application/json")
	public List<Book> searchByAuthor(@PathVariable("author") String author) {
		List<Book> bookList = feignClient.searchByAuthor(author);
		return bookList;
	}

	@GetMapping(value = "/find-book/{bookId}")
	public Book viewBookDetails(@PathVariable("bookId") int id) {
		Book book = feignClient.viewBookDetails(id);
		return book;
	}


}
