package com.bytes.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bytes.main.TaskManagementSystemApplication;
import com.bytes.repo.TaskRepository;
import com.bytes.utils.Task;
import com.bytes.utils.User;
import com.bytes.utils.Work;

//import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@SpringBootTest(classes = TaskManagementSystemApplication.class)
public class TaskServiceImplTests {

	@MockBean
	TaskRepository taskRepository;

	@Autowired
	TaskService taskService;

	@Test
	void getAllTasks() {

		int taskID = 1;
		String title = "Sample Task";
		String description = "This is a sample task description.";
		int priority = 1;
		String status = "In Progress";
		User userID = new User(4001, "Ram", "ram@gmail.com", "ram123", null);
		LocalDate dueDate = LocalDate.of(2023, 8, 24);
		Work workID = new Work(8000, "Sample Work", status);
		double score = 0.0;

		Task task = new Task(taskID, title, description, priority, status, userID, dueDate, workID, score);

		Mockito.when(taskRepository.findAll()).thenReturn(Arrays.asList(task, task));
		assertEquals(2, taskService.getAllTasks().size());
	}

	@Test
	void getTasksByUserId() {
		int userId = 123;
		List<Task> dummyTasks = new ArrayList<>();

		dummyTasks.add(new Task());
//		     dummyTasks.add(new Task(2, "Task 2", "Description 2"));

		Mockito.when(taskRepository.findByUserID_UserID(userId)).thenReturn(dummyTasks);
		List<Task> result = taskService.getTasksByUserId(userId);

		Mockito.verify(taskRepository).findByUserID_UserID(userId);

		assertEquals(dummyTasks, result);

	}

	@Test
	public void deleteTaskById() {
		int taskId = 123;

		// Call the deleteTask method
		taskService.deleteTask(taskId);

		// Verify that the deleteById method of the mocked repository is called with the
		// correct taskId
		Mockito.verify(taskRepository).deleteById(taskId);
	}

	@Test
	public void updateTaskPriority() {
		int taskId = 1;
		Task existingTask = new Task(taskId, "Sample Task", "Description", 1, "In Progress", null, null, null, 0.0);
		Task updatedTask = new Task(taskId, "Sample Task", "Description", 2, "In Progress", null, null, null, 0.0);

		Mockito.when(taskRepository.findById(taskId)).thenReturn(Optional.of(existingTask));
		Mockito.when(taskRepository.save(existingTask)).thenReturn(updatedTask);

		// Act
		Task result = taskService.updateTaskPriority(taskId, updatedTask);

		// Assert
		assertEquals(updatedTask, result);
	}

	@Test
	void testUpdateTaskPriority_TaskNotFound() {
		int taskID = 2; // Use a non-existing taskID for the test

		// Mock the taskRepository to return an empty Optional (indicating the task was
		// not found)
		Mockito.when(taskRepository.findById(taskID)).thenReturn(Optional.empty());

		// Create a dummy Task object to pass to the method (you can set any priority
		// you want)
		Task task = new Task();
		task.setPriority(5);

		// Call the method and verify that it throws EntityNotFoundException
		assertThrows(EntityNotFoundException.class, () -> {
			taskService.updateTaskPriority(taskID, task);
		});
	}

	@Test
	void testAddtaskDetails() {
		// Create a dummy Task object to pass to the method
		Task task = new Task();
		task.setTaskID(1);
		task.setTitle("Sample Task");
		task.setDescription("This is a sample task description.");
		task.setPriority(1);
		task.setStatus("In Progress");

		// Mock the taskRepository's save method
		Mockito.when(taskRepository.save(task)).thenReturn(task);

		// Call the method
		taskService.addtaskDetails(task);

		// Verify that the taskRepository's save method was called with the correct Task
		// object
		Mockito.verify(taskRepository, times(1)).save(task);

	}

//	 
//		@Test
//		public void updateTaskStatus(){
//		 int taskId = 1;
//	    Task existingTask = new Task(taskId, "Sample Task", "Description", 1, "In Progress", null, null, null, 0.0);
//	    Task updatedTask = new Task(taskId, "Sample Task", "Description", 1, "Completed", null, null, null, 0.0);
//
//	    Mockito.when(taskRepository.findById(taskId)).thenReturn(Optional.of(existingTask));
//	    Mockito.when(taskRepository.save(existingTask)).thenReturn(updatedTask);
//
//	    // Act
//	    Task result = taskService.updateTaskStatus(existingTask);
//
//	    // Assert
//	    assertEquals(updatedTask, result);
//	    }

//		
//		 @Test
//		    void testUpdateTaskStatus_TaskExists() {
//		        // Create a dummy task object as input
//		        Task task = new Task();	
//		        task.setTaskID(1);
//		        task.setStatus("Completed");
//
//		        Object objectTask=task;
//		        // Mock the taskRepository's findById method to return the dummy task
//		        Mockito.when(taskRepository.findById(1)).thenReturn(Optional.of(task));
//
//		        // Call the method
//		        Task result = taskService.updateTaskStatus(objectTask);
//
//		        // Verify that the taskRepository's save method was called with the correct Task object
//		        Mockito.verify(taskRepository, times(1)).save(task);
//
//		        // Check the result returned by the method
//		        assertEquals("Completed", result.getStatus());
//		    }
//	 

	@Test
	void testUpdateTaskStatus_TaskNotFound() {
		// Create a dummy task object as input
		Task task = new Task();
		task.setTaskID(1);
		task.setStatus("Completed");

		// Mock the taskRepository's findById method to return an empty Optional
		Mockito.when(taskRepository.findById(1)).thenReturn(Optional.empty());

		// Call the method and verify that it throws EntityNotFoundException
		assertThrows(EntityNotFoundException.class, () -> {
			taskService.updateTaskStatus(task);
		});
	}

	@Test
	void testGetTaskById_TaskExists() {
		int taskId = 1;
		Task expectedTask = new Task(taskId, "Sample Task", "Description", 1, "In Progress", null, null, null, 0.0);

		// Mock the taskRepository's findById method to return the expectedTask
		Mockito.when(taskRepository.findById(taskId)).thenReturn(Optional.of(expectedTask));

		// Call the method
		Task result = taskService.getTaskById(taskId);

		// Verify the repository method was called
		Mockito.verify(taskRepository, times(1)).findById(taskId);

		// Check that the returned task matches the expected task
		assertEquals(expectedTask, result);
	}

	@Test
	void testDeleteTaskByUserID() {
		int userId = 4001;

		// Call the method

		taskService.deleteTaskByUserID(userId);

		// Verify the repository method was called
		Mockito.verify(taskRepository, times(1)).deleteTasksByUserId(userId);
	}

}
