package myapp.library.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import myapp.library.model.Book;
import myapp.library.service.BookService;
import myapp.library.web.dto.BookDTO;

@RestController
@RequestMapping(value = "api/books")
public class ApiBookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BookDTO>> getBooks() {
		List<Book> books = bookService.findAll();
		List<BookDTO> booksDTO = new ArrayList<>();
		for (Book book : books) {
			booksDTO.add(new BookDTO(book));
		}

		return new ResponseEntity<>(booksDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BookDTO> getBook(@PathVariable Long id) {
		Book book = bookService.findOne(id);
		if (book == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new BookDTO(book), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<BookDTO> deleteBook(@PathVariable Long id) {
		Book book = bookService.findOne(id);
		if (book == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		bookService.remove(id);

		//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(new BookDTO(book), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/JSON")
	public ResponseEntity<BookDTO> saveBook(
			@RequestBody BookDTO bookDTO) {
		Book book = new Book();
		book.setName(bookDTO.getName());

		Book bookSaved = bookService.save(book);
		return new ResponseEntity<>(new BookDTO(bookSaved),
				HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/JSON")
	public ResponseEntity<BookDTO> editBook(
			@RequestBody BookDTO bookDTO, @PathVariable Long id) {
		if (bookDTO.getId() == null || bookDTO.getId() != id) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Book book = bookService.findOne(id);
		if (book != null) {
			book.setName(bookDTO.getName());

			Book bookSaved = bookService.save(book);
			return new ResponseEntity<>(new BookDTO(bookSaved), 
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}
