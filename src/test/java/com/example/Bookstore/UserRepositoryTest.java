package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@DataJpaTest
class UserRepositoryTest {

	@Autowired
	private UserRepository repository;
	
	@Test
	public void createNewCategory() {
		User user = new User("Newbie", "Newbie", "newbie@gmail.com", "USER");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void findCategory() {
		User user = repository.findByUsername("admin");
		
		assertThat(user).isNotNull();
		assertThat(user.getEmail()).isEqualTo("admin@hh.fi");
	}
	
	@Test
	public void deleteCategory() {
		User user = repository.findByUsername("user");
		
		assertThat(user).isNotNull();
		
		repository.delete(user);
		
		assertThat(repository.findByUsername("user")).isNull();
	}

}
