package com.bytes.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bytes.utils.Task;

import jakarta.transaction.Transactional;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	
	   List<Task> findByUserID_UserID(int userID);
	   
	   List<Task> findByDescriptionAndPriority(String decription,int priority);
	   
//	   void deleteByUserID_UserID(int userID);
//	   void deleteByUserIDId(int userId); 
//	   void deleteByUserUserID(int userId);
	   
	   
	   @Modifying @Transactional @Query

	  ("DELETE  FROM Task t WHERE t.userID.userID = :userId") 
	   void deleteTasksByUserId(int userId);
}


