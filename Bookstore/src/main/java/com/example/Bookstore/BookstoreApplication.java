package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner Books(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			
			log.info("save a couple of categories");
			crepository.save(new Category("Science"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Thriller"));
			
			log.info("save a couple of books");
			repository.save(new Book("Astrophysics for people in a hurry", "Neil DeGrase Tyson", "2017", "978-0-393-60939-4", 49.99, crepository.findByName("Science").get(0)));
			repository.save(new Book("A brief history of time", "Stephen Hawking", "2016", "978-0-857-50100-0", 60.00, crepository.findByName("Science").get(0)));
			repository.save(new Book("The Bible", "Jesus", "0", "000-0-000-00000-1", 1.00, crepository.findByName("Fantasy").get(0)));	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			 
		};
	}

}
