package com.promineotech.FinalProject.Service;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.FinalProject.Entity.ListingCategories;
import com.promineotech.FinalProject.Entity.Listings;
import com.promineotech.FinalProject.Repository.ListingCategoriesRepository;
import com.promineotech.FinalProject.Repository.ListingRepository;
@Service
public class ListingService {
	
	private static final Logger logger = LogManager.getLogger(ListingService.class);
	
	@Autowired
	private ListingRepository repo;
	
	@Autowired
	private ListingCategoriesRepository categoryRepo;
	
	public Iterable<Listings> getListings() {
		return repo.findAll();
	}
	
	public Listings createListing(Listings listing) {
		Listings newlistings = new Listings();
		Iterable<ListingCategories> listingCatIterable = categoryRepo.findAll();
		
		Set<ListingCategories> newSet = new HashSet<ListingCategories>();
		
		Set<ListingCategories> list=new HashSet<ListingCategories>();
		list.addAll(listing.getCategories());
		
		for (ListingCategories oneListingCategory : listingCatIterable) {
			logger.info("database category: " + oneListingCategory.getListingCategoryID());
			for (ListingCategories listcat: list) {
				logger.info("parameter category: " + listcat.getListingCategoryID());
				if (oneListingCategory.getListingCategoryID() == listcat.getListingCategoryID()) {
					logger.info("listcat Id: " + listcat.getListingCategoryID());
					newSet.add(listcat);
				}
			}
		}
		
		logger.info("In create Listing" + list);
		newlistings.setUser(listing.getUser());
		newlistings.setListingPrice(listing.getListingPrice());
		logger.info("In create Listing" + newlistings.getUser());

	
		Listings savedlisting=new Listings();
		
		savedlisting= repo.save(newlistings);
		savedlisting.setCategories(newSet);
		return repo.save(savedlisting);
		}
	

	
	
	public Listings updateListings(Listings listings, Long ListingID) throws Exception {
		
		try {
			Listings oldListing = repo.findOne(ListingID);
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