package com.library.book.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.book.model.Subscription;

public interface SubscribeRepo extends JpaRepository <Subscription, String> {
	
	public List<Subscription> findByName(String name);

}
