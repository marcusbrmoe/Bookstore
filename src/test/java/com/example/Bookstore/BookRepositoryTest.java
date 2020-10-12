package com.example.Bookstore;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
class BookRepositoryTest {

	@Autowired
	private BookRepository repository;
	
	@Test
	public void createNewBook() {
		Book book = new Book("The World", "Marcus Moe", "2020", "100-023-495-20202-2", 20.30, new Category("Awsome"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void findBook() {
		List<Book> book = repository.findByAuthor("Stephen Hawking");
		
		assertThat(book).hasSize(1);
		assertThat(book.get(0).getTitle()).isEqualTo("A brief history of time");
	}
	
	@Test
	public void deleteBook() {
		List<Book> book = repository.findByAuthor("Jesus");
		
		assertThat(book).hasSize(1);
		
		repository.delete(book.get(0));
		
		assertThat(repository.findByAuthor("Jesus")).isNullOrEmpty();
	}
}
