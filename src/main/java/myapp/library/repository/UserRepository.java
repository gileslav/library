package myapp.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myapp.library.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
