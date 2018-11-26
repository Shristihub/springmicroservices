package com.bookapp.hystrixclient.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.bookapp.hystrixclient.model.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class OrderService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final String BASEURL = "http://ORDER-SERVICE/";
	
	@HystrixCommand(fallbackMethod="fallbackSearch")
	public List<Book> searchByAuthor(String author) {
		String url = BASEURL + "order-service/search-author/" + author;
		List<Book> bookList = restTemplate.getForObject(url,List.class);
		return bookList;
	}
	public List<Book> fallbackSearch(String author) {
		List<Book> bookList = new ArrayList<>();
		return bookList;
	}
	
	@HystrixCommand(fallbackMethod="fallbackViewBook")
	public Book viewBookDetails(int id) {
		String uri = BASEURL + "order-service/view-book/" + id;
		Book book = restTemplate.getForObject(uri, Book.class);
		return book;
	}
	
	public Book fallbackViewBook(int id) {
		Book book = new Book("No books available ","nil",0.0,"nil");
		return book;
	}
}
