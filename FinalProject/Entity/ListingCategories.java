package com.promineotech.FinalProject.Entity;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class ListingCategories {
	
	private Long category_id;
	private String description;
	private Set<Listings> listings;
	
	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getListingCategoryID() {
		return category_id;
	}
	
	public void setListingCategoryID(Long id) {
		this.category_id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
    @ManyToMany(fetch=FetchType.EAGER,mappedBy = "categories")
    @JsonBackReference
	public Set<Listings> getListing() {
		return listings;
	}
	public void setListing(Set<Listings> listings) {
		this.listings = listings;
	}
	
	
}