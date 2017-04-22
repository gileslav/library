package myapp.library.service.impl;

import java.util.List;

import myapp.library.model.User;
import myapp.library.repository.UserRepository;
import myapp.library.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaUserService implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void remove(Long id) throws IllegalArgumentException {
		userRepository.delete(id);
	}

}
