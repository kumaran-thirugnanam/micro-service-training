package com.library.book.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.library.book.model.Book;

public interface BookRepo extends JpaRepository<Book, String> {

}
