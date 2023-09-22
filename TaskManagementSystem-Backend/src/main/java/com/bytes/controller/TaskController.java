package com.bytes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bytes.service.TaskServiceImpl;
import com.bytes.utils.Task;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

	@Autowired
	private TaskServiceImpl taskService;

//	create task	
	@PostMapping("/task")
	public ResponseEntity<Integer> addtaskDetails(@RequestBody Task task) {
		taskService.addtaskDetails(task);
		return ResponseEntity.ok(200);
	}	 
	
//  view tasks
	@GetMapping("/viewTask")
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}

//  delete tasks
	@DeleteMapping("/deleteTask/{taskId}")
	public ResponseEntity<Integer> deleteTask(@PathVariable int taskId) {
		taskService.deleteTask(taskId);
		return ResponseEntity.ok(200);
	}

//  update status of task
	@PostMapping("/updatestatus")
	public String updateTaskStatus(@RequestBody Object task) {
		taskService.updateTaskStatus(task);
		return "status changed";
	}

//	update priority	  
	@PutMapping("/priority/{taskID}")
	public Task updateTaskPriority(@PathVariable int taskID, @RequestBody Task task) {
		return taskService.updateTaskPriority(taskID, task);
	}

//  display task by id
	@GetMapping("searchBytask/{taskId}")
	public ResponseEntity<?> getTaskById(@PathVariable int taskId) {
		Task task = taskService.getTaskById(taskId);
		if (task != null) {	
			return ResponseEntity.ok(task);
		} else {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND)
			            .body("Task with ID " + taskId + " does not exist");
		}
	}

//  display task by userid
	@GetMapping("searchByuser/{userId}")
	public ResponseEntity<?> getTaskByUserId(@PathVariable int userId) {
	    List<Task> tasks = taskService.getTasksByUserId(userId);
	    if (!tasks.isEmpty()) {
	        return ResponseEntity.ok(tasks);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	            .body("Task with userID " + userId + " does not exist");
	    }
	}
	
//  automatic priority calculation
	@GetMapping("/priorityscore/{taskId}")
	public List<Task> getTaskPriority(@PathVariable int taskId) {
		List<Task> task = taskService.getAllTasks();
		return taskService.calculatePriorityScore(task);
	}
	
}
