package com.rb.hopeapp.repository;

import java.util.List;

import com.rb.hopeapp.domain.ProductCategory;
import com.rb.hopeapp.exception.NoSuchNameException;


public interface ProductCategoryDao {
	
	public ProductCategory findById(int id);
	public ProductCategory findByName(String name) throws NoSuchNameException;
	public List<ProductCategory> getProductCategories();
	public ProductCategory saveProductCategory(ProductCategory category);
	public boolean deleteProductCategory (ProductCategory category);

}
