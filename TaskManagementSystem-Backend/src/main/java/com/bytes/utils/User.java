package com.bytes.utils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_seq", allocationSize = 1, initialValue = 4001)
   
	private int userID;
//	@Column(name="\"name\"")
	private String name;
//	@Column(name="\"email\"")
	@Column(unique = true)
	private String email;
	private String password;
	@ManyToOne
	@JoinColumn(name = "roleID")
	private UserRole roleID;

	public User() {

	}
 
	public User(int userID, String name, String email,String password, UserRole roleID) {
		super();
		this.userID = userID;
		this.name = name;	
		this.email = email;
		this.roleID = roleID;
		this.password=password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public UserRole getRoleID() {
		return roleID;
	}

	public void setRoleID(UserRole roleID) {
		this.roleID = roleID;
	}

}
