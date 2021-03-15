package com.promineotech.FinalProject.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.FinalProject.Entity.ListingCategories;
import com.promineotech.FinalProject.Repository.ListingCategoriesRepository;

@Service
public class ListingCategoriesService {
	
	
@Autowired 
private ListingCategoriesRepository repo;

	public Iterable<ListingCategories> getalllistingcategories() { 

	return repo.findAll();
	
	}
	
	public ListingCategories getlistingcategories(long id) { 

	return repo.findOne(id);
	
	
	}
	
public ListingCategories createListingCategories(ListingCategories listingcategories) {
		
		ListingCategories newListingCategories = new ListingCategories();
		

		newListingCategories.setListing(listingcategories.getListing());
		newListingCategories.setDescription(listingcategories.getDescription());
		

		
	return repo.save (newListingCategories);
	
}	
}

	
	
	

