package com.example.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.Bookstore.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findByAuthor(String author);
}
