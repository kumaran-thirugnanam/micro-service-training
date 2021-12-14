package com.library.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.book.model.Book;
import com.library.book.repo.BookRepo;

@Service
public class BookService {
	
	@Autowired
	BookRepo bRepo;
	
	
	public List<Book> getAll(){
		return bRepo.findAll();
	}

}
