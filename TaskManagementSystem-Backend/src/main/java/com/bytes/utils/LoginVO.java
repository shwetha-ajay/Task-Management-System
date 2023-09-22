package com.bytes.utils;

public class LoginVO {
	private String email;
	private String roleName;
	
	public LoginVO(String email, String roleName) {
		super();
		this.email = email;
		this.roleName = roleName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
