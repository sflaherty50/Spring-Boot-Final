package com.promineotech.FinalProject.Service;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.FinalProject.Entity.ListingCategories;
import com.promineotech.FinalProject.Entity.Listings;
import com.promineotech.FinalProject.Repository.ListingCategoriesRepo;
import com.promineotech.FinalProject.Repository.ListingRepository;


@Service
public class ListingService {
	
	private static final Logger logger = LogManager.getLogger(ListingService.class);
	
	@Autowired
	private ListingRepository repo;
	
	@Autowired
	private ListingCategoriesRepo ListCatRepo;
	
	public Iterable<Listings> getListings() {
		return repo.findAll();
	}
	
	public Listings createListing(Listings listing) {
	Listings newlistings = new Listings();
	Set<ListingCategories> list=new HashSet<ListingCategories>();
	list=listing.getCategories();
	logger.info("In create Listing" + list);
	newlistings.setUser(listing.getUser());
//	newlistings.setCategories(listing.getCategories());
	newlistings.setListingPrice(listing.getListingPrice());
	logger.info("In create Listing" + newlistings.getUser());
	newlistings.getCategories().addAll(list);
	

	
		return repo.save(newlistings);
	}
	
	//public Listings getListing(Long ListingCategoriesID) {
	//	return repo.findAll(ListingCategoriesID);
	//}
	
	
	public Listings updateListings(Listings listings, Long ListingID) throws Exception {
		try {
			Listings oldListing = repo.findOne(ListingID);
//			oldListing.setListingCategoryID(Listings.getListingCategoryID());
//			oldListing.setListingPrice(Listings.getListingPrice());
//			oldListing.setListingDate(Listings.getDate());
			return repo.save(oldListing);
		} catch (Exception e) {
			logger.error("Exception occured while trying to update listing: " + ListingID, e);
			throw new Exception("Unable to update listing.");
		}
	}
	
	public void removeListing(Long ListingID) throws Exception {
		try {
			repo.delete(ListingID);
		}catch (Exception e) {
			logger.error("Exception occured while trying to delete listing: " + ListingID, e);
			throw new Exception("Unable to delete listing.");
		}
	}

	
	
	
	
	
}
	
	
	


