package com.bytes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytes.repo.UserRepository;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {
	@Autowired
	UserRepository userRepository;

}

