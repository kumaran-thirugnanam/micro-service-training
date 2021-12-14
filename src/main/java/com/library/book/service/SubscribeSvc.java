package com.library.book.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.book.model.Book;
import com.library.book.model.Subscription;
import com.library.book.repo.BookRepo;
import com.library.book.repo.SubscribeRepo;

@Service
public class SubscribeSvc {

	@Autowired
	SubscribeRepo subRepo;

	@Autowired
	BookRepo bookRepo;

	public List<Subscription> getAll() {
		return subRepo.findAll();
	}

	public List<Subscription> getSubscribe(String name) {
		//return subRepo.findById(name);
		return subRepo.findByName(name);
	}

	public String save(Subscription sub) {
		subRepo.save(sub);
		return "saved";
	}

	public String createSubs(Subscription sub) {
		String status = null;
		if (sub.getBookId() != null) {
			Optional<Book> fetchB = bookRepo.findById(sub.getBookId());
			Book book = fetchB.orElse(null);
			if (book != null) {
				if ("subscribe".equalsIgnoreCase(sub.getType())) {
					if (book.getAvailable() > 0) {
						save(sub);
						status = "Subscribed";

						book.setAvailable(book.getAvailable() - 1);
						bookRepo.save(book);
					} else {
						status = "NotAvilable for Subscription";
					}
				}else if ("return".equalsIgnoreCase(sub.getType())) {
					sub.setReturnDate(new Date(System.currentTimeMillis()));
					int count = book.getAvailable();
					if(count< book.getTotal()) {
						book.setAvailable(book.getAvailable() + 1);
						status = "Subscription returned for "+book.getName();
						save(sub);
						bookRepo.save(book);
					}
				}else {
					status = "Subscription Type required ['subscribe' or 'return']";
				}
			}
		}
		return status;
	}

}
