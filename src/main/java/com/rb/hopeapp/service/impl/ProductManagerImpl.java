package com.rb.hopeapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



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
import com.rb.hopeapp.repository.ProductDaoImpl;
import com.rb.hopeapp.repository.ProductDtlDao;
import com.rb.hopeapp.repository.StatusDao;
import com.rb.hopeapp.repository.UnitConversionDao;
import com.rb.hopeapp.service.ProductManager;
import com.rb.hopeapp.util.AppUtil;

//@Service("productService")
public class ProductManagerImpl implements ProductManager{
	static Logger logger = Logger.getLogger(ProductManagerImpl.class);
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private ProductDao productDao;
	private UnitConversionDao unitConversionDao;
	private StatusDao statusDao;
	private ProductCategoryDao productCategoryDao;
	private ProductDtlDao productDtlDao;
	


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

	@Transactional
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
				productDtl.setCreatedBy(AppUtil.getInstance().getUser());
				productDtl.setLastUpdatedBy(AppUtil.getInstance().getUser());
				productDtl.setLastUpdatedDate(AppUtil.getInstance().getCurrentDate());
				productDtl.setCreatedDate(AppUtil.getInstance().getCurrentDate());
				productDtls.add(productDtl);
				
			}
		}
		product.setCreatedDate(AppUtil.getInstance().getCurrentDate());
		product.setUpdateDate(AppUtil.getInstance().getCurrentDate());
		product.setCreatedBy(AppUtil.getInstance().getUser());
		product.setUpdateBy(AppUtil.getInstance().getUser());
		product.setProductDtls(productDtls);
		logger.info("exccute save");
		product = productDao.saveProduct(product);
		
		return product;
	}
	
	public double computeProductTotalQtyOnHand(Product product) throws NoSuchNameException {
		double totalQtyonHand=0;
		logger.info(product.getProductDtls().toString());
		if (product.getProductDtls()!=null) {
			for (ProductDtl dtl : product.getProductDtls()) {
				UnitConversion unit = unitConversionDao.findByName(dtl.getUnitConversion().getName());
				totalQtyonHand += dtl.getQtyOnHand() * unit.getFactor();
			}
		}
		return totalQtyonHand;
	}

	public List<ProductDtl> getProductDtls(String q) {
		if (q!=null && q.length() > 2)
			return productDtlDao.findProductDtlsLike(q);
		else 
			return productDtlDao.findAll();
	}
	
	

	
	public void updateProductInventory(int productDtlId, int qty) {
		// TODO Auto-generated method stub
		double qtyOnHand = 0.0;
		ProductDtl productDtl = productDtlDao.findById(productDtlId);
		if (productDtl.getQtyOnHand() >= qty) {
			qtyOnHand = productDtl.getQtyOnHand() - qty;
			
		}
		else {
			// get qty from other dtl
//			productDao.
		}
		productDtl.setQtyOnHand(qtyOnHand);
	}

	/******************** setters and getters ***********************/
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public UnitConversionDao getUnitConversionDao() {
		return unitConversionDao;
	}

	public void setUnitConversionDao(UnitConversionDao unitConversionDao) {
		this.unitConversionDao = unitConversionDao;
	}

	public ProductCategoryDao getProductCategoryDao() {
		return productCategoryDao;
	}

	public void setProductCategoryDao(ProductCategoryDao productCategoryDao) {
		this.productCategoryDao = productCategoryDao;
	}

	public StatusDao getStatusDao() {
		return statusDao;
	}

	public void setStatusDao(StatusDao statusDao) {
		this.statusDao = statusDao;
	}
	public ProductDtlDao getProductDtlDao() {
		return productDtlDao;
	}

	public void setProductDtlDao(ProductDtlDao productDtlDao) {
		this.productDtlDao = productDtlDao;
	}

	
	

}
