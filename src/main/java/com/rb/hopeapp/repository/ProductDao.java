package com.rb.hopeapp.repository;

import java.util.List;

import com.rb.hopeapp.domain.Product;
import com.rb.hopeapp.exception.ProductNotSaveException;



public interface ProductDao {

	Product findById(int id);
	Product saveProduct(Product product) throws ProductNotSaveException;
	boolean deleteProduct(Product product);
	List<Product> findByCategory(String category);
	List<Product> findByName(String name);
}
