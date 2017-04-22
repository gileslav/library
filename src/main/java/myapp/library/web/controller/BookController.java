package myapp.library.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import myapp.library.model.Book;
import myapp.library.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostConstruct
	private void init() {
		// Book newBook = new Book();
		// newBook.setName("Kapital - Karl Marks");
		// bookService.save(newBook);
		//
		// newBook.setName("Snezana i sedam patuljaka - Karl Marks");
		// bookService.save(newBook);
		//
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getBooks(Model model) {
		List<Book> books = bookService.findAll();
		model.addAttribute("booksModel", books);
		model.addAttribute("booksCount", books.size());
		return "books";
	}

	@RequestMapping(value = "/remove/{id}")
	public String remove(@PathVariable Long id) {
		bookService.remove(id);
		return "redirect:/books";
	}

	@RequestMapping(value = "/add")
	public String add(Model model) {
		model.addAttribute("book", new Book());
		return "addEditBook";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("book", bookService.findOne(id));

		return "addEditBook";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String post(Book book, BindingResult bindingResult,
			Model model) {

		bookService.save(book);
		return "redirect:/books";

	}

	@RequestMapping("name/{name}")
	public String findByName(Model model, @PathVariable String name) {
		List<Book> book = bookService.findByName(name);
		model.addAttribute("bookModel", book);
		return "books";
	}

}
