package myapp.library.service.impl;

import java.util.List;

import myapp.library.model.Book;
import myapp.library.repository.BookRepository;
import myapp.library.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class JpaBookService implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book findOne(Long id) {
		
		return bookRepository.findOne(id);
	}

	@Override
	public List<Book> findAll() {
		
		return bookRepository.findAll();
	}

	@Override
	public Book save(Book book) {
		
		return bookRepository.save(book);
	}

	@Override
	public void remove(Long id) throws IllegalArgumentException {
		Book book = bookRepository.findOne(id);
		if(book == null){
			throw new IllegalArgumentException("Tried to remove nonexistant book id:" + id);
		}
		
		bookRepository.delete(book);
	}

	@Override
	public List<Book> findByName(String string) {
		
		return bookRepository.findByNameLike("%" + string + "%");
	}

}
