package com.example.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.Bookstore.domain.Book;

@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findByAuthor(String author);
}
