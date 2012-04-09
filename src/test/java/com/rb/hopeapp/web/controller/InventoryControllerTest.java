package com.rb.hopeapp.web.controller;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.rb.hopeapp.domain.Product;
import com.rb.hopeapp.service.impl.ProductManagerImpl;

import junit.framework.TestCase;

public class InventoryControllerTest extends TestCase {
	
	public void testHandleRequestView() throws Exception{
        InventoryController controller = new InventoryController();
//        controller.setProductManager(new ProductManagerImpl());
//        ModelAndView modelAndView = controller.handleRequest(null, null);
//        assertEquals("hello", modelAndView.getViewName());
//        assertNotNull(modelAndView.getModel());
//        Map<String, Object> modelMap = (Map) modelAndView.getModel().get("model");
//        String nowValue = (String) modelMap.get("now");
//        assertNotNull(nowValue);
    }

}
