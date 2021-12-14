package com.library.book.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.book.model.Book;
import com.library.book.model.Subscription;
import com.library.book.service.BookService;
import com.library.book.service.SubscribeSvc;

@RestController
@RequestMapping("api/library")
public class LibraryController {

	@Autowired
	BookService bookSvc;

	@Autowired
	SubscribeSvc subSvc;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> books = bookSvc.getAll();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	@GetMapping("/subscriptions")
	public ResponseEntity<List<Subscription>> getSubscriptions(@RequestParam(required = false) String name) {
		List<Subscription> subs = null;
		if (name != null) {
			subs = subSvc.getSubscribe(name);
			
		} else {
			subs = subSvc.getAll();
		}
		return new ResponseEntity<>(subs, HttpStatus.OK);
	}
	
	@PostMapping("/subscriptions")
	public ResponseEntity<String> subscribe(@RequestBody Subscription sub){
		String status = subSvc.createSubs(sub);
		//subSvc.save(sub);		
		return new ResponseEntity<>(status,HttpStatus.ACCEPTED);
	}

}
