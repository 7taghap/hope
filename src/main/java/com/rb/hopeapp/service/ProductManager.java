package com.rb.hopeapp.service;

import java.io.Serializable;
import java.util.List;

import com.rb.hopeapp.domain.Product;
import com.rb.hopeapp.domain.ProductCategory;
import com.rb.hopeapp.domain.ProductDtl;
import com.rb.hopeapp.domain.UnitConversion;
import com.rb.hopeapp.exception.NoCategoriesException;
import com.rb.hopeapp.exception.NoSuchNameException;
import com.rb.hopeapp.exception.NoSuchStatusException;
import com.rb.hopeapp.exception.ProductNotSaveException;

public interface ProductManager extends Serializable {
    
	public Product getProduct(int id);
    public List<Product> getProducts();
    public void setProducts(List<Product> products);
    public List<UnitConversion> getUnitConversions();
    public List<String> getProductCategories() throws NoCategoriesException;
    public List<String> getUnitList();
    public Product saveProduct(Product product) throws ProductNotSaveException,
    NoSuchNameException,NoSuchStatusException;

    public List<ProductDtl> getProductDtls();
    public double computeProductTotalQtyOnHand(Product product) throws NoSuchNameException;
    
}
