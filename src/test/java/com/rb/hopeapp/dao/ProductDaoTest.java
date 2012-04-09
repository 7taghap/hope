package com.rb.hopeapp.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rb.hopeapp.domain.Product;
import com.rb.hopeapp.domain.ProductCategory;
import com.rb.hopeapp.domain.ProductDtl;
import com.rb.hopeapp.domain.Status;
import com.rb.hopeapp.domain.UnitConversion;
import com.rb.hopeapp.exception.NoSuchNameException;
import com.rb.hopeapp.exception.ProductNotSaveException;
import com.rb.hopeapp.repository.ProductCategoryDao;
import com.rb.hopeapp.repository.ProductDao;
import com.rb.hopeapp.repository.UnitConversionDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-config.xml"})
public class ProductDaoTest {
	static Logger logger = Logger.getLogger(ProductDaoTest.class);
	@Autowired
	ProductDao productDao;
	
	@Autowired
	UnitConversionDao unitConversionDao;
	
	@Autowired
	ProductCategoryDao productCategoryDao;
	@Test
	public void saveProduct() throws NoSuchNameException {
		List<ProductDtl> productDtls = new ArrayList<ProductDtl>();
		//look up table
				UnitConversion unit = unitConversionDao.findByName("gram");
//				unit.setName("gram");
//				unit.setId(1);
//				unit.setFactor(000.1);
//				unit.setu
				Status status = new Status();
				status.setStatusName("Active");
				status.setStatusId(1);
				
				ProductCategory category = productCategoryDao.findByName("beverages");
//				category.setCategoryName("Beverages");
//				category.setDescription("Beverages");
//				category.setProductCategoryId(1);
				
				//stub up for product
				ProductDtl dtl1 = new ProductDtl();
				dtl1.setCreatedBy("testng");
				dtl1.setCreatedDate(new Date());
				dtl1.setLastUpdatedBy("testng");
				dtl1.setPrice(2.50);
				dtl1.setPriceType(1);
				dtl1.setQtyOnHand(100.00);
				dtl1.setSellingQty(5.5);
				dtl1.setSugPrice(5.5);
				dtl1.setStatus(status);
//				UnitConversion dtlUnit = new UnitConversion(); //query if dili slow
//				dtlUnit.setId(2);
				dtl1.setUnitConversion(unit);
				productDtls.add(dtl1);
				
				Product product = new Product();
				product.setCategory(category);
				product.setCreatedBy("testng");
				product.setCreatedDate(new Date());
				product.setProductDesc("product test");
				product.setProductName("TESTNG");
				product.setProductType(1);
				product.setShelf("in da room");
				product.setTotalQtyOnHand(10);
				product.setProductDtls(productDtls);
				product.setUnitConversion(unit);
				try {
				product = productDao.saveProduct(product);
				}catch(ProductNotSaveException e) {
					e.printStackTrace();
				}
				logger.info(product.toString());
		
	}
	
	public void getProducts() {
		List<Product> products = productDao.findByCategory("beverages");
		System.out.println("size products "+ products.size());
//		UnitConversion unit = unitConversionDao.findById(1);
//		assertNotNull(unit);
//		Product product = productDao.findById(1000);
//		assertNull(product);
//		products.add(product);
		assertEquals(products, new ArrayList<Product>());
//		assertNotNull(products);
	}

}
