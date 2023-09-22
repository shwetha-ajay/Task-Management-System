package com.bytes.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytes.utils.User;

public interface SuperAdminRepository extends JpaRepository<User, Integer> { 


}
