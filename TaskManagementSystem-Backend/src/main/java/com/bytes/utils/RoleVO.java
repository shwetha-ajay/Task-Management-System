package com.bytes.utils;

public class RoleVO {


	private String name;
	private String email;
	private String password;
	private String userRole;
	public RoleVO() {

	}
	
	public RoleVO(String name, String email, String password, String userRole) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


}
