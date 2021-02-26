package com.promineotech.FinalProject.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



public class Transaction {
	
	private Long TransactionID;
	private Long UserID;
	private Long ListingID;
	private Date TransactionDate;
	


		public Long getUserID() {
			return UserID;
		}
	 

		public void setUserID(Long userID) {
			UserID = userID;
		}
	
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "id")
		public Long getListingID() {
			return ListingID;
		}
		
		public void setListingID(Long ListingID) {
			ListingID = getListingID();
		}
		
		public Date getTransactionDate() {
			return TransactionDate;
		}
		public void setTransactionDate(Date transactionDate) {
			TransactionDate = transactionDate;
		}

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		public Long getTransactionID() {
			return TransactionID;
		}

		public void setTransactionID(Long transactionID) {
			TransactionID = transactionID;
		}
		}	
		
		
		
