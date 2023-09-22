package com.bytes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytes.repo.TaskRepository;
import com.bytes.repo.UserRepository;
import com.bytes.utils.User;

@Service

public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	TaskRepository taskRepository;

	
	@Override
	public User login(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);

	}

//  add new admin
	@Override
	public void addAdmin(User admin) {
		userRepository.save(admin);
	}

//  fetch all users
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

//  delete admin    
	@Override
	public void deleteAdmin(int userId) {
		taskRepository.deleteTasksByUserId(userId);
		userRepository.deleteById(userId);

	}

//  fetch userid by email    
	public int getUserIdByEmail(String email) {
		User user = userRepository.findByEmail(email);
		if (user != null) {
			return user.getUserID();
		} else {
			throw new IllegalArgumentException("User not found");
		}
	}

//   list all the userIds	
	public List<Integer> getUserIds() {
		return userRepository.findAllUserIds();
	}



}
