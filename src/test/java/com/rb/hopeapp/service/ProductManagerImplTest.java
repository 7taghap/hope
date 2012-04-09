package com.rb.hopeapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.rb.hopeapp.domain.Product;
import com.rb.hopeapp.domain.ProductCategory;
import com.rb.hopeapp.domain.ProductDtl;
import com.rb.hopeapp.domain.Status;
import com.rb.hopeapp.domain.UnitConversion;
import com.rb.hopeapp.service.impl.ProductManagerImpl;

import junit.framework.TestCase;

public class ProductManagerImplTest extends TestCase {

	private ProductManager productManager;
	
	List<Product> products;
	List<ProductDtl> productDtls;
	private static int PRODUCT_COUNT = 1;
    
	private static String PRODUCTNAME= "testproduct";
	
	protected void  setup() throws Exception {
		productManager = new ProductManagerImpl();
		products = new ArrayList<Product>();
		productDtls = new ArrayList<ProductDtl>();
		//look up table
		UnitConversion unit = new UnitConversion();
		unit.setName("gram");
		unit.setId(1);
		unit.setFactor(000.1);
//		unit.setu
		Status status = new Status();
		status.setStatusName("Active");
		status.setStatusId(1);
		
		ProductCategory category = new ProductCategory();
		category.setCategoryName("Beverages");
		category.setDescription("Beverages");
		category.setProductCategoryId(1);
		
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
		UnitConversion dtlUnit = new UnitConversion(); //query if dili slow
		dtlUnit.setId(2);
		dtl1.setUnitConversion(dtlUnit);
		productDtls.add(dtl1);
		
		Product product = new Product();
		product.setCategory(category);
		product.setCreatedBy("testng");
		product.setCreatedDate(new Date());
		product.setProductDesc("product test");
		product.setProductName(PRODUCTNAME);
		product.setProductType(1);
		product.setShelf("in da room");
		product.setTotalQtyOnHand(10);
		
		product.setUnitConversion(unit);
		
		product.setProductDtls(productDtls);
		
		products.add(product);
		productManager.setProducts(products);
		
	}
	
	 public void testGetProductsWithNoProducts() {
		 productManager = new ProductManagerImpl();
		 assertNull(productManager.getProducts());
	 }
	 
	 public void testGetProducts() {
	        List<Product> products = productManager.getProducts();
	        assertNotNull(products);        
	        assertEquals(PRODUCT_COUNT, productManager.getProducts().size());
	    
	        Product product = products.get(0);
	        assertEquals(PRODUCTNAME, product.getProductName());
	      
	        
	      
	    }   
}
