package com.promineotech.FinalProject.Entity;

import javax.persistence.OneToOne;

public class Credentials {
	
	private String UserName;
	private String password;
	
	
	@OneToOne(mappedBy = "UserName")
	public String getUserName() {
		return UserName;
	}
	public void setUsername(String userName) {
		this.UserName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
