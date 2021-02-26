package com.promineotech.FinalProject.Entity;

import javax.persistence.OneToOne;

public class Credentials {
	
	private long id;
	private String UserName;
	private String password;
	
	
	
	public String getUserName() {
		return UserName;
	}
	public void setUsername(String UserName) {
		this.UserName = UserName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
