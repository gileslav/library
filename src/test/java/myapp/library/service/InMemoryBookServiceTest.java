package myapp.library.service;

import java.util.List;

import myapp.library.model.Book;
import myapp.library.service.BookService;
import myapp.library.service.impl.InMemoryBookService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InMemoryBookServiceTest {
	private BookService bookService;
	
	@Before
	public void setUp(){
		bookService = new InMemoryBookService();
		
		Book someBook = new Book();
		someBook.setName("Lelejska gora");
		Book someOtherBook = new Book();
		someOtherBook.setName("Njegoski prsut, kako ga spremiti");
		
		bookService.save(someBook);
		bookService.save(someOtherBook);
	}
	
	@Test
	public void testFindOne(){
		Book book = bookService.findOne(1L);
		Assert.assertNotNull(book);
		Assert.assertEquals("Swimming", book.getName());
	}
	
	@Test
	public void testFindAll(){
		List<Book> books = bookService.findAll();
		Assert.assertNotNull(books);
		Assert.assertEquals(2, books.size());
		
	}
	
}
