package com.promineotech.FinalProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.FinalProject.Entity.Listings;
import com.promineotech.FinalProject.Service.ListingService;


@RestController
@RequestMapping("/listings")
public class ListingController {


		@Autowired
		private ListingService service;
		
		
		
		@RequestMapping(value="/{id}",method=RequestMethod.GET)
		public ResponseEntity<Object> getListings() {
			return new ResponseEntity<Object>(service.getListings(), HttpStatus.OK);
		}
		

		
		
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Object> createListings(@RequestBody Listings listings) {
			return new ResponseEntity<Object>(service.createListing(listings), HttpStatus.CREATED);
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Object> updateListings(@RequestBody Listings listings, @PathVariable Long id) {
			try {
				return new ResponseEntity<Object>(service.updateListings(listings, id), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>("Unable to update listing", HttpStatus.NOT_FOUND);
			}
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Object> deleteListings(@PathVariable Long id) {
			try {
				service.removeListing(id);
				return new ResponseEntity<Object>("Successfully deleted listing with id: " + id, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>("Unable to delete listing", HttpStatus.NOT_FOUND);
			}
		}
}		

