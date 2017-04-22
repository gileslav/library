package myapp.library.web.dto;

import myapp.library.model.Book;

public class BookDTO {
	private Long id;
	private String name;
	
	public BookDTO() {
		super();
	}

	public BookDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public BookDTO(Book book){
		super();
		this.id = book.getId();
		this.name = book.getName();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
