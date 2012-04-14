package com.rb.hopeapp.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.rb.hopeapp.web.controller.InventoryController;


@Configuration
public class ControllerConfig {
	
	
	//autowire service config
	@Autowired
	ServiceConfig serviceConfig;
	
	@Bean
	public InventoryController getInventoryController() {
		return new InventoryController(serviceConfig.getProductManager());
	}

}
