package com.rb.hopeapp.web;

import org.springframework.context.annotation.Bean;

import com.rb.hopeapp.repository.ProductCategoryDao;
import com.rb.hopeapp.repository.ProductDao;
import com.rb.hopeapp.repository.StatusDao;
import com.rb.hopeapp.repository.UnitConversionDao;

public interface DaoConfig {

	@Bean
	ProductDao getProductDao();
	
	@Bean
	ProductCategoryDao getProductCategoryDao();
	
	@Bean
	UnitConversionDao getUnitConversionDao();
	
	@Bean
	StatusDao getStatusDao();
	
	
	
}
