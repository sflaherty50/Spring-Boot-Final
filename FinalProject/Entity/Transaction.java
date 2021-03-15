package com.promineotech.FinalProject.Entity;


import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


public class Transaction {
	
	private Long id;
	private Users user;
	private Listings listing;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getTransactionID() {
		return id;
}

	public void setTransactionID(Long id) {
		this.id = id;
	}


		public Users getUserID() {
			return user;
		}
	 

		public void setUserID(Users user) {
			this.user = user;
		}
	
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "id")
		public Listings getListingID() {
			return listing;
		}
		
		public void setListingID(Listings listing) {
			this.listing = listing;
		}


}