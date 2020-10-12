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
import com.example.Bookstore.domain.Login;
import com.example.Bookstore.domain.LoginRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner Books(BookRepository repository, CategoryRepository crepository, LoginRepository urepository) {
		return (args) -> {
			/*
			log.info("save a couple of categories");
			crepository.save(new Category("Science"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Thriller"));
			
			log.info("save a couple of books");
			repository.save(new Book("Astrophysics for people in a hurry", "Neil DeGrase Tyson", "2017", "978-0-393-60939-4", 49.99, crepository.findByName("Science").get(0)));
			repository.save(new Book("A brief history of time", "Stephen Hawking", "2016", "978-0-857-50100-0", 60.00, crepository.findByName("Science").get(0)));
			repository.save(new Book("The Bible", "Jesus", "0", "000-0-000-00000-1", 1.00, crepository.findByName("Fantasy").get(0)));	
			
			log.info("Create users");
			urepository.save(new Login("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@hh.fi", "USER"));
			urepository.save(new Login("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@hh.fi", "ADMIN"));
			*/
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
			log.info("fetch all users");
			for (Login login : urepository.findAll()) {
				log.info(login.toString());
			}
		};
	}

}
