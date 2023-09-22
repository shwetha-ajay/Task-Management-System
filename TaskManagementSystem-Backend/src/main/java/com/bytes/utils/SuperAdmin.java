package com.bytes.utils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SuperAdmin")
public class SuperAdmin {
	@Id
	@Column(name = "\"usernName\"")
	private String userName;
	@Column(name = "\"password\"")
	private String password;

	public SuperAdmin() {

	}

}
