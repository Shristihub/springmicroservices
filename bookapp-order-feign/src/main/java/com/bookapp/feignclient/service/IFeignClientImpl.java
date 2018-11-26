package com.bookapp.feignclient.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookapp.feignclient.model.Book;
@Component
public class IFeignClientImpl implements IFeignClient {

	@Override
	public List<Book> searchByAuthor(String author) {
		System.out.println("fall back for author");
		return new ArrayList<>();
	}

	@Override
	public Book viewBookDetails(int id) {
		System.out.println("fall back for bookid");
		return new Book("nil","nil", 0.0,"nil");
	}

}
