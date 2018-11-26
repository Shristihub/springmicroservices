package com.bookapp.ribbonclient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bookapp.ribbonclient.model.Book;

@RestController
@RequestMapping("/ribbon-service")
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	private final String BASEURL = "http://BOOK-SERVICE/";

	@RequestMapping(value = "/search-author/{author}", produces = "application/json")
	public List<Book> searchByAuthor(@PathVariable("author") String author) {
		String url = BASEURL + "/users/books-by-author/" + author;
		int port = loadBalancerClient.choose("BOOK-SERVICE").getPort();
		System.out.println("******port****" + port);
		List<Book> bookList = restTemplate.getForObject(url, List.class);
		return bookList;
	}

	@RequestMapping(value = "/view-book/{bookId}")
	public Book viewBookDetails(@PathVariable("bookId") int id) {
		String uri = BASEURL + "/users/book-by-id/" + id;
		Book book = restTemplate.getForObject(uri, Book.class);
		return book;
	}

}
