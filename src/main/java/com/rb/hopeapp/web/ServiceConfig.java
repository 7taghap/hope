package com.rb.hopeapp.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rb.hopeapp.service.ProductManager;


@Configuration
public interface ServiceConfig {
	
	@Bean 
	public ProductManager getProductManager();

}
