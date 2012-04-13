package com.rb.hopeapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.hopeapp.domain.Product;
import com.rb.hopeapp.domain.ProductCategory;
import com.rb.hopeapp.domain.ProductDtl;
import com.rb.hopeapp.domain.Status;
import com.rb.hopeapp.domain.UnitConversion;
import com.rb.hopeapp.exception.NoCategoriesException;
import com.rb.hopeapp.exception.NoSuchNameException;
import com.rb.hopeapp.exception.NoSuchStatusException;
import com.rb.hopeapp.exception.ProductNotSaveException;
import com.rb.hopeapp.repository.ProductCategoryDao;
import com.rb.hopeapp.repository.ProductDao;
import com.rb.hopeapp.repository.StatusDao;
import com.rb.hopeapp.repository.UnitConversionDao;
import com.rb.hopeapp.service.ProductManager;

//@Service
public class ProductManagerImpl implements ProductManager{
	static Logger logger = Logger.getLogger(ProductManagerImpl.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	ProductDao productDao;
	
	@Autowired
	UnitConversionDao unitConversionDao;
	
	@Autowired
	ProductCategoryDao productCategoryDao;
	
	@Autowired
	StatusDao statusDao;

	public List<Product> getProducts()  {
		return productDao.findByCategory("beverages");
	}

	public void setProducts(List<Product> products) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public Product getProduct(int id) {
		return productDao.findById(id);
	}

	public List<UnitConversion> getUnitConversions() {
		return unitConversionDao.getAllUnitConversion();
	}

	public List<String> getProductCategories() throws NoCategoriesException {
		List<String> categories = new ArrayList<String>();
		for(ProductCategory category :productCategoryDao.getProductCategories()) {
			categories.add(category.getCategoryName());
		}
		if (categories.size() < 0)
			throw new NoCategoriesException("No Categories Seeded");
		
		return categories;
	}

	public List<String> getUnitList() {
		List<String> units = new ArrayList<String>();
		for (UnitConversion unit : unitConversionDao.getAllUnitConversion()) {
			units.add(unit.getName());
		}
		return units;
	}

	public Product saveProduct(Product product) throws ProductNotSaveException,
	NoSuchNameException, NoSuchStatusException {
		System.out.println("save invoke");
		if (product.getUnitConversion()!=null) {
			if(product.getUnitConversion().getId() < 1 && 
					product.getUnitConversion().getName()!=null) {
				UnitConversion unit = unitConversionDao.findByName(product.getUnitConversion().getName());
				logger.info("unit for product :"+ unit.toString());
				product.setUnitConversion(unit);
			}
		}
		if (product.getCategory()!=null) {
			if (product.getCategory().getProductCategoryId() < 1 && 
				product.getCategory().getCategoryName()!=null) {
				ProductCategory category = productCategoryDao.findByName(product.getCategory().getCategoryName());
				product.setCategory(category);
			}
		}
		//set the product detail status to active
		List<ProductDtl> productDtls = new ArrayList<ProductDtl>();
		if (product.getProductDtls()!=null) {
			Status status = statusDao.getActive();
			for (ProductDtl productDtl : product.getProductDtls()) {
				productDtl.setStatus(status);
				UnitConversion unit = unitConversionDao.findByName(productDtl.getUnitConversion().getName());
				logger.info("unit for product dtl:"+ unit.toString());
				productDtl.setUnitConversion(unit);
//				productDtl.set
				productDtls.add(productDtl);
			}
		}
//		product.setstatusDao.getActive();
		product.setProductDtls(productDtls);
		logger.info("exccute save");
		product = productDao.saveProduct(product);
		
		return product;
	}
	
	

}
