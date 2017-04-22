package myapp.library.service;

import java.util.List;

import myapp.library.model.Book;

public interface BookService {

	Book findOne(Long id);
	List<Book> findAll();
	Book save(Book activity);
	void remove(Long id) throws IllegalArgumentException;
	List<Book> findByName(String string);
}
