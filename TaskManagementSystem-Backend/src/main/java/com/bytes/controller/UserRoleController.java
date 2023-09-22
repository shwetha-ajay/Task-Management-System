package com.bytes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bytes.service.UserRoleService;
import com.bytes.utils.UserRole;

@RestController
public class UserRoleController {
	@Autowired	
	UserRoleService userRoleService;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	@PostMapping
	public String adderUserRole(@RequestBody UserRole role) {
		userRoleService.addUserRole(role);
		return "added";
	}	

}
