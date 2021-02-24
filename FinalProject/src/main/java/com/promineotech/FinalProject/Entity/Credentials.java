package com.promineotech.FinalProject.Entity;

import javax.persistence.OneToOne;

public class Credentials {
	
	private long id;
	private Users UserName;
	private String password;
	
	
	@OneToOne(mappedBy = "UserName")
	public Users getUserName() {
		return UserName;
	}
	public void setUsername(Users UserName) {
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
