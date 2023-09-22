package com.bytes.service;

import java.util.List;

import com.bytes.utils.Task;

public interface TaskService {

	public void addtaskDetails(Task task);

	public List<Task> getAllTasks();

	public void deleteTask(int taskId);

	Task updateTaskPriority(int taskID, Task task);

	Task getTaskById(int taskId);


	List<Task> getTasksByUserId(int userId);

	List<Task> calculatePriorityScore(List<Task> task);

	void deleteTaskByUserID(int userId);

	Task updateTaskStatus(Object task);
	

}
