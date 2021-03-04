package com.promineotech.FinalProject.Entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class ListingCategories {
	
	private Long id;
	private String description;
	private Set<Listings> listings;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getListingCategoryID() {
		return id;
	}
	
	public void setListingCategoryID(Long id) {

		this.id = id;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}
	
	@ManyToMany(mappedBy = "categories")
	public Set<Listings> getListing() {
		return listings;
	}

	public void setListing(Set<Listings> listings) {
		this.listings = listings;
	} 
	
	

}