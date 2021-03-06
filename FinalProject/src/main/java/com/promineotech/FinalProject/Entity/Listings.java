package com.promineotech.FinalProject.Entity;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Listings {
	
	private Long listing_id;
	private Set<ListingCategories> categories;
	private Users user;
	private double ListingPrice;
	private LocalDate ListingDate;
	
	@Id
	@Column(name = "listing_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getListingID() {
		return listing_id;
	}
	
	public void setListingID(Long id) {
		this.listing_id = id;
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
	
	public LocalDate getListingDate() {
		return ListingDate.now();
	}
	
	public void setListingDate(LocalDate listingDate) {
		ListingDate = listingDate;
		
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "listings_by_categories",
			joinColumns = @JoinColumn(name = "listing_id", referencedColumnName = "listing_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
	public Set<ListingCategories> getCategories() {
		return categories;
	}
	
	public void setCategories(Set<ListingCategories> categories) {
		this.categories = categories;
	}

	
}