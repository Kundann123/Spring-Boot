package com.dbmodule.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbmodule.exception.UserDetailsNotFoundException;
import com.dbmodule.model.User;
import com.dbmodule.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		List<User> user = new ArrayList<User>();
		userRepository.findAll().forEach(user::add);
		return user;
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public Optional<User> userById(int id) {
		return userRepository.findById(id);
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	
	public User updateUserDetails(User user) {
		Optional<User> userData = userRepository.findById(user.getId());
		if (userData.isPresent()) {
			User fetchedData = userData.get();
			fetchedData.setName(user.getName());
			fetchedData.setEmail(user.getEmail());
			return userRepository.save(fetchedData);
		}else {
			throw new UserDetailsNotFoundException("User not found for ID :"+ user.getId());
		}
	}
	
}
