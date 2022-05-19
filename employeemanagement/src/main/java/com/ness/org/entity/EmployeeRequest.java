package com.ness.org.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class EmployeeRequest {

	private String username;
	private String password;
	
	
	public EmployeeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmployeeRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
