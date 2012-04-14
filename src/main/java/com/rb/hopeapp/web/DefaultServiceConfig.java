package com.rb.hopeapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rb.hopeapp.service.ProductManager;
import com.rb.hopeapp.service.impl.ProductManagerImpl;

@Configuration
public class DefaultServiceConfig implements ServiceConfig{

	
	//autowire dao config
	@Autowired
	DaoConfig daoConfig;
	
	@Bean
	public ProductManager getProductManager() {
		// TODO Auto-generated method stub
		return new ProductManagerImpl(daoConfig.getProductDao(),daoConfig.getUnitConversionDao(),
				daoConfig.getProductCategoryDao(),daoConfig.getStatusDao());
	}

}
