package com.bytes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytes.utils.Work;

@Repository
public interface WorkRepository extends JpaRepository<Work,Integer>{
	
	}

