package com.promineotech.FinalProject.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Listings {
	
	private Long ListingID;
	private Long ListingCategoryID;
	private Users user;
	private double ListingPrice;
	private Date ListingDate;
	private boolean ListingStatus;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ListingID")
	public Long getListingID() {
		return ListingID;
	}
	
	public void setListingID(Long listingID) {
		ListingID = listingID;
	}
	
  
	public Long getListingCategoryID() {
		return ListingCategoryID;
	}
    
	public void setListingCategoryID(Long listingCategoryID) {
		ListingCategoryID = listingCategoryID;
	}
	
	@ManyToOne
	@JoinColumn(name = "userId")
	public Users getUser() {
	  return user;
	}
	public void setUser(Users user) {
	  this.user = user;
	}
	
	public double getListingPrice() {
		return ListingPrice;
	}
	public void setListingPrice(double listingPrice) {
		ListingPrice = listingPrice;
	}
	public Date getListingDate() {
		return ListingDate;
	}
	public void setListingDate(Date listingDate) {
		ListingDate = listingDate;
	}
	public boolean isListingStatus() {
		return ListingStatus;
	}
	public void setListingSold(boolean listingStatus) {
		ListingStatus = listingStatus;
	}
	

}
