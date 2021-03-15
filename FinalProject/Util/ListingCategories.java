package com.promineotech.FinalProject.Util;

public enum ListingCategories {
	
	Category1 ("1", "Furniture"),
	Category2 ("2", "Sports"),
	Category3 ("3", "Automotive"),
	Category4 ("4", "Utilities"),
	Category5 ("5", "Appliances"),
	Category6 ("6", "Luxury"),
	Category7 ("7", "Outdoors"),
	Category8 ("8", "Seasonal"),
	Category9 ("9", "Technology");
	
	private final String catID;
	private final String catdesc;
	
	ListingCategories(String CategoryID, String CategoryDesc) {
	catID = CategoryID;
	catdesc = CategoryDesc;
	}
	
	public String getcatID() {
		return catID;
	}
	
	public String getcatdesc() {
		return catdesc;

}
}
