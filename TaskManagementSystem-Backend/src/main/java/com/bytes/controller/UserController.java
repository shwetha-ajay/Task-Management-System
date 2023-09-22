package com.bytes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bytes.service.UserRoleService;
import com.bytes.service.UserService;
import com.bytes.service.UserServiceImpl;
import com.bytes.utils.LoginVO;
import com.bytes.utils.User;
import com.bytes.utils.UserRole;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	UserService userService;	
	UserServiceImpl userServiceImpl;
	UserRoleService userRoleService;
	
	
	

	 @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody User loginRequest) {
	        User user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
	        if (user != null) {
	             user.getRoleID().getName();
	             LoginVO loginVO = new LoginVO(user.getEmail(),user.getRoleID().getName());        
	                return ResponseEntity.ok(loginVO);
	            
	        } 
	        // Invalid credentials or role not found
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid login credentials.");
	    }
	
	 
	 
//  add new user	
	@RequestMapping(value = "user", method = RequestMethod.POST)
	public String adderUser(@RequestBody User user) {	
		System.out.println("sts error");
		userService.addUser(user);
		return "user added";
	}

//  fetch userid by email
	@GetMapping("/userid")
	public ResponseEntity<Integer> getUserIdByEmail(@RequestParam String email) {
		int userId = userService.getUserIdByEmail(email);
		return ResponseEntity.ok(userId);
	}
	
//  list all userIds
    @GetMapping("/ids")
    public List<Integer> getUserIds() {
        return userService.getUserIds();
    }
  

}
