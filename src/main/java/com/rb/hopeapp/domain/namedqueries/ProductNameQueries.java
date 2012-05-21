package com.rb.hopeapp.domain.namedqueries;

public class ProductNameQueries {
	//parameters
	public static final String PARAM_NAME = "productName";
	
	public static final String FIND_BY_CATEGORY	= "Product.findByCategory";
	public static final String FIND_BY_NAME = "Product.findByName";
	public static final String FIND_ALL_DETAILS = "ProductDtl.findAll";
	public static final String FIND_DETAILS_BY_CATEGORY = "ProductDtl.findByCategory";
	public static final String FIND_DETAILS_BY_NAME = "ProductDtl.findByName";
	public static final String FIND_DETAILS_LIKE_NAME = "ProductDtl.LikeName";
	public static final String FIND_PRODUCT_DETAIL_WITH_HIGER_UNIT = "ProductDtl.findByHigherUnit";
}
