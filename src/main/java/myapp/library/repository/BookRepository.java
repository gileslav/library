package myapp.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import myapp.library.model.Book;

@Repository
public interface BookRepository 
extends JpaRepository<Book, Long> {

//	@Query("select a from Activity a where a.name = :name")
//	List<Activity> findByName(@Param("name") String name);
	
	List<Book> findByNameLike(String name);
}
