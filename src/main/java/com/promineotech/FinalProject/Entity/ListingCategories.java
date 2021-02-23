package com.promineotech.FinalProject.Entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ListingCategories {
	
	private Long ListingCategoryID;
	private String Description;
	private Set<Listings> listings;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getListingCategoryID() {
		return ListingCategoryID;
	}
	
	public void setListingCategoryID(Long listingCategoryID) {
		ListingCategoryID = listingCategoryID;
	}

	
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	@OneToMany(mappedBy = "listings")
	public Set<Listings> getListing() {
		return listings;
	}

	public void setListing(Set<Listings> listings) {
		this.listings = listings;
	} 
	
	

}
