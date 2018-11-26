package com.bookapp.feignclient.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bookapp.feignclient.model.Book;


@FeignClient(value="order-service")
public interface IFeignClient {
	
	@GetMapping(value = "/order-service/search-author/{author}", produces = "application/json")
	public List<Book> searchByAuthor(@PathVariable("author") String author) ;
		

	@GetMapping(value = "/order-service/view-book/{bookId}")
	public Book viewBookDetails(@PathVariable("bookId") int id);

}
