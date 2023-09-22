package com.bytes.service;

import java.util.List;

import com.bytes.utils.User;

public interface UserService {

	public void addUser(User user);

	public void addAdmin(User admin);

	public List<User> getAllUsers();

	public void deleteAdmin(int userId);

	public int getUserIdByEmail(String email);

	public List<Integer> getUserIds();

//	public ResponseEntity<Login> loginDetails(User login);

	public User login(String email, String password);

}
