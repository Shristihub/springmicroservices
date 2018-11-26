package com.bookapp.webclient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.bookapp.webclient.model.Book;

@Controller
public class BookClientController {

	@Autowired
	private RestTemplate restTemplate;

	private final String BOOKURL = "http://localhost:9000/bookapi/books";
	private final String ORDERURL = "http://localhost:9000/bookapi/orders";

	@GetMapping(value = "/")
	public String home(ModelMap map) {
		String uri = BOOKURL + "/users/all-books";
		List<Book> bookList = restTemplate.getForObject(uri, List.class);
		map.addAttribute("bookList", bookList);
		return "home";
	}

	@GetMapping(value = "/search")
	public String searchBooks(@RequestParam("author") String author, ModelMap map) {
		String uri = ORDERURL + "/order-service/search-author/" + author;
		List<Book> bookList = restTemplate.getForObject(uri, List.class);
		map.addAttribute("bookList", bookList);
		return "home";
	}

	@GetMapping(value = "/view/{bookId}")
	public String orderBook(@PathVariable("bookId") int id, ModelMap map) {
		String uri = ORDERURL + "/order-service/view-book/" + id;
		Book book = restTemplate.getForObject(uri, Book.class);
		map.addAttribute("book", book);
		return "final";
	}

	@GetMapping(value = "/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping(value = "/addbookform")
	public String addBookForm(Model model) {
		Book book = new Book();
		model.addAttribute("book",book);
		return "addbookform";
	}

	@PostMapping(value = "/addbook")
	public String addBook(Book book, ModelMap map) {
		String uri =BOOKURL + "/admin/add-book";
		restTemplate.postForObject(uri, book, ResponseEntity.class);
		return "admin";
	}

}
