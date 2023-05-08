package com.axsos.LoginAndRegistration.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.axsos.LoginAndRegistration.models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findAll();
}
