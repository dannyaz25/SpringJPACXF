package com.companyName.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyName.modelo.User;
import com.companyName.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	private static final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private UserRepository userRepository;
	
	private static List<User> users;
	
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	public User findById(long id) {
		return userRepository.findOne(id);
	}
	
	public User findByName(String name) {
		return userRepository.findByUsername(name);
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(User user) {
		userRepository.save(user);
	}

	public void deleteUserById(long id) {
		userRepository.delete(id);
	
	}

	public boolean isUserExist(User user) {
		return findByName(user.getUsername())!=null;
	}
	
	public void deleteAllUsers(){
		userRepository.deleteAll();
	}

}
