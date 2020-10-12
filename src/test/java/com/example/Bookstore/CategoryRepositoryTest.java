package com.example.Bookstore;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Cool");
		repository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	@Test
	public void findCategory() {
		List<Category> category = repository.findByName("Science");
		
		assertThat(category).hasSize(1);
		assertThat(category.get(0).getName()).isEqualTo("Science");
	}
	
	@Test
	public void deleteCategory() {
		List<Category> category = repository.findByName("Fantasy");
		
		assertThat(category).hasSize(1);
		
		repository.delete(category.get(0));
		
		assertThat(repository.findByName("Fantasy")).isNullOrEmpty();
	}
}
