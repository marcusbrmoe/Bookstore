package com.example.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Login, Long> {
	Login findByUsername(String username);
}
