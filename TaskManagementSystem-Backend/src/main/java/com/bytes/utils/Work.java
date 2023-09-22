package com.bytes.utils;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Work")
public class Work {
	@Id
	private int workID;
	private String title;
	private String description;

	public Work() {

	}

	public Work(int workID, String title, String description) {
		super();
		this.workID = workID;
		this.title = title;
		this.description = description;
	}

	public int getWorkID() {
		return workID;
	}

	public void setWorkID(int workID) {
		this.workID = workID;
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

}
