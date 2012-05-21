package com.rb.hopeapp.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
@RequestMapping("/sales")
public class SalesController {
	
	private static final Logger logger = Logger.getLogger(SalesController.class);
	
	
	public ModelAndView createSales() {
		
		
		return new ModelAndView("createSales");
	}

}
