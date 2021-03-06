package com.promineotech.FinalProject.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Users {

	private Long id; 
	private String hash;
	private String username;
	private Set<Listings> listings;


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getUserID() {
		return id;
	}
	public void setUserID(Long id) {
		this.id = id;
	}
	
	@Column(unique = true)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	@OneToMany(mappedBy = "user")
	public Set<Listings> getListings() {
	  return listings;
	}
	public void setListings(Set<Listings> listings) {
	  this.listings = listings;
	}
	
}