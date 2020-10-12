package com.example.Bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.Bookstore.web.BookController;

@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private BookController controller;
	
	@Test 
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	

}
