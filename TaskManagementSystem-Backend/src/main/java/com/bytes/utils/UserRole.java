package com.bytes.utils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userrole")
public class UserRole {
	@Id
	private int roleID;
	@Column(name = "name")
	private String name;
	
	public UserRole() {
	}
	
	public UserRole(int roleID, String name) {
		super();
		this.roleID = roleID; 
		this.name = name;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
