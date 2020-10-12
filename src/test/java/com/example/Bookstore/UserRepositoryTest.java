package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.Bookstore.domain.Login;
import com.example.Bookstore.domain.LoginRepository;

@DataJpaTest
class UserRepositoryTest {

	@Autowired
	private LoginRepository repository;
	
	@Test
	public void createNewCategory() {
		Login user = new Login("Newbie", "Newbie", "newbie@gmail.com", "USER");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void findCategory() {
		Login user = repository.findByUsername("admin");
		
		assertThat(user).isNotNull();
		assertThat(user.getEmail()).isEqualTo("admin@hh.fi");
	}
	
	@Test
	public void deleteCategory() {
		Login user = repository.findByUsername("user");
		
		assertThat(user).isNotNull();
		
		repository.delete(user);
		
		assertThat(repository.findByUsername("user")).isNull();
	}

}
