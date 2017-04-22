package myapp.library.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myapp.library.model.Book;
import myapp.library.service.BookService;

import org.springframework.stereotype.Service;

//@Service
public class InMemoryBookService implements BookService {

	private Map<Long, Book> data = new HashMap<>();
	private Long idCounter = 1L;
	
	@Override
	public Book findOne(Long id) {
		return data.get(id);
	}

	@Override
	public List<Book> findAll() {
		return new ArrayList<>(data.values());
	}

	@Override
	public Book save(Book book) {
		if (book.getId() == null) {
			book.setId(idCounter);
			idCounter++;
		}
		data.put(book.getId(), book);
		return book;
	}

	@Override
	public void remove(Long id) throws IllegalArgumentException {
		Book book = data.remove(id);
		if (book == null) {
			throw new IllegalArgumentException("Removing unexisting book with id=" + id);
		}
	}

	@Override
	public List<Book> findByName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
