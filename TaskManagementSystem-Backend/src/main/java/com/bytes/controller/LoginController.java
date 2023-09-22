//package com.bytes.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bytes.repo.UserRepository;
//import com.bytes.service.LoginService;
//import com.bytes.utils.Login;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//public class LoginController {
//	@Autowired
//	LoginService loginService;
//	UserRepository userRepository;
//
//	@PostMapping("/login1")	
//	public ResponseEntity<Login> loginUser(@RequestBody Login login) {
//		return loginService.loginDetails(login);
//		
////	@PostMapping("/login")
////	public ResponseEntity<Login> loginUser(@RequestBody Login login) {
////		loginService.loginDetails(login);
////		return ResponseEntity.ok(login);
////
////		
//	}
//}
