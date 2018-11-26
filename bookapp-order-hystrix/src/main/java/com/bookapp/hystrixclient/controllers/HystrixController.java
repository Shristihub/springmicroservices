package com.bookapp.hystrixclient.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bookapp.hystrixclient.model.Book;
import com.bookapp.hystrixclient.service.OrderService;


@RestController
@RequestMapping("/hystrix-service")
public class HystrixController {
	
	@Autowired
	private OrderService orderService;
	@GetMapping(value = "/search-author/{author}", produces = "application/json")
	public List<Book> searchByAuthor(@PathVariable("author") String author) {
		List<Book> bookList = orderService.searchByAuthor(author);
		return bookList;
	}

	@GetMapping(value = "/view-book/{bookId}")
	public Book viewBookDetails(@PathVariable("bookId") int id) {
		Book book = orderService.viewBookDetails(id);
		return book;
	}
	
}
