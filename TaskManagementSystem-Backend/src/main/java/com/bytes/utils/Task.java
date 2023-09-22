package com.bytes.utils;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_sequence")
   @SequenceGenerator(name = "task_sequence", sequenceName = "task_seq", allocationSize = 1, initialValue = 7001)
	private int taskID;
	private String title;
	private String description;
	private LocalDate dueDate;
	private int priority;
	private String status;
	@ManyToOne
	@JoinColumn(name = "userID")
	private User userID;
	@ManyToOne
	@JoinColumn(name = "workID")
	private Work workID;
	private Double score;

	public Task() {

	}

	public Task(int taskID, String title, String description, int priority, String status, User userID,
			LocalDate dueDate, Work workID,double score) {
		super();
		this.taskID = taskID;
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.userID = userID;
		this.dueDate = dueDate;
		this.workID = workID;
		this.score=score;
	}

	public int getTaskID() {
		return taskID;
	}	

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUserID() {
		return userID;
	}

	public void setUserID(User userID) {
		this.userID = userID;
	}

	public Work getWorkID() {
		return workID;
	}

	public void setWorkID(Work workID) {
		this.workID = workID;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
    public Double getScore() {
    	return score;
    }
    
    public void setScore(Double score) {
    	this.score=score;
    }

}
