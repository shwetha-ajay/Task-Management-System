package com.bytes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bytes.service.UserService;
import com.bytes.utils.RoleVO;
import com.bytes.utils.User;
import com.bytes.utils.UserRole;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class SuperAdminController {

	@Autowired
	UserService userService;

	// add new user
	@PostMapping("/addUsers")
	public ResponseEntity<Integer> addAdmin(@RequestBody RoleVO admin) {
		User user = new User();
		user.setEmail(admin.getEmail());
		user.setName(admin.getName());
		user.setPassword(admin.getPassword());

		if (admin.getUserRole().equals("Admin")) {
			UserRole userRole = new UserRole(101, "Admin");
			user.setRoleID(userRole);
		}
		if (admin.getUserRole().equals("User")) {
			UserRole userRole = new UserRole(102, "User");
			user.setRoleID(userRole);
		}
		if (admin.getUserRole().equals("superAdmin")) {
			UserRole userRole = new UserRole(103, "superAdmin");
			user.setRoleID(userRole);
		}
		userService.addAdmin(user);
		return ResponseEntity.ok(200);
	}

	// view admin list
	@GetMapping("/viewAdmin")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// delete admin
	@DeleteMapping("deleteAdmin/{userId}")
	public ResponseEntity<Integer> deleteAdmin(@PathVariable int userId) {

		userService.deleteAdmin(userId);
		return ResponseEntity.ok(200);
	}

}
