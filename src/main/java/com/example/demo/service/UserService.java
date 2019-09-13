package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

/**
 * Documentation
 *
 * @author Sunil Dabburi
 * @since 1.0.0
 */
@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> listAll() {
		return repo.findAll();
	}

	public void save(User user) {
		repo.save(user);
	}

	public User get(int id) {
		return repo.findById(id).get();
	}

	public void delete(int id) {
		repo.deleteById(id);
	}
}
