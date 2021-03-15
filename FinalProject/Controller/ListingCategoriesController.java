package com.promineotech.FinalProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.FinalProject.Entity.ListingCategories;
import com.promineotech.FinalProject.Service.ListingCategoriesService;

@RestController
@RequestMapping ("/listingcategories")
public class ListingCategoriesController {
	
@Autowired
private ListingCategoriesService service;

@RequestMapping(method=RequestMethod.GET)
public ResponseEntity<Object> getalllistingcategories() {
	return new ResponseEntity<Object>(service.getalllistingcategories(), HttpStatus.OK);
}


@RequestMapping(value="/{id}",method=RequestMethod.GET)
public ResponseEntity<Object> getlistingcategories(@PathVariable Long id) {
	return new ResponseEntity<Object>(service.getlistingcategories(id), HttpStatus.OK);
}

@RequestMapping(method=RequestMethod.POST)
public ResponseEntity<Object> createListingCategories(@RequestBody ListingCategories listingcategories) {
	return new ResponseEntity<Object>(service.createListingCategories(listingcategories), HttpStatus.CREATED);
}
	

}
