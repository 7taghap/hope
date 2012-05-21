package com.rb.hopeapp.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.mapping.Array;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rb.hopeapp.domain.ProductDtl;
import com.rb.hopeapp.domain.Sale;
import com.rb.hopeapp.domain.SalesDtl;
import com.rb.hopeapp.exception.SaleNotSaveException;
import com.rb.hopeapp.repository.SalesDao;
import com.rb.hopeapp.repository.SalesDtlDao;
import com.rb.hopeapp.util.AppUtil;

import junit.framework.Assert;
import junit.framework.TestCase;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-config.xml"})
public class SalesServiceTest extends TestCase{

	static Logger logger = Logger.getLogger(SalesServiceTest.class);
	@Autowired
	SalesService salesService;

	@Autowired
	ProductManager productManager;




	public void setup() throws Exception {
		logger.info(salesService);
	}
	
	
	public void testGetSales() {
		assertNotNull(salesService);
		List<SalesDtl> list = salesService.getAllSalesDetail();
		Assert.assertNotNull(list);
	}
	
	@Test
	public void createSales() throws SaleNotSaveException {
		Sale sale = new Sale();
		sale.setCustomer(1);
		sale.setCreatedBy(AppUtil.getInstance().getUser());
		sale.setRemarks("test saving");
		sale.setStatus(1);
		
		SalesDtl saleDtl = new SalesDtl();
		List<ProductDtl> productDtls = productManager.getProductDtls("chippy");
		saleDtl.setProduct(productDtls.get(0));
		saleDtl.setQty(1);
		saleDtl.setStatus(1);
		saleDtl.setAmt(6d);
		List<SalesDtl> sales = new ArrayList<SalesDtl>();
		sales.add(saleDtl);
		sale.setSalesDtls(sales);
		sale = salesService.saveSale(sale);
		assertTrue("save successful", sale.getSalesId() > 0);
//		saleDtl.set
	}
	
}
