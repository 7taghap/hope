package com.rb.hopeapp.web.controller;

import org.apache.log4j.Logger;
//import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.io.IOException;
import java.util.Date;

@org.springframework.stereotype.Controller
public class HelloController {

    protected final Logger logger = Logger.getLogger(getClass());
    
    @RequestMapping("/hello.html")
    public ModelAndView helloWorld() {
    	
    	String now = (new Date()).toString();
      logger.info("Returning hello view with " + now);

     return new ModelAndView("hello","now", now);
    }

//    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//    	 String now = (new Date()).toString();
//         logger.info("Returning hello view with " + now);
//
//        return new ModelAndView("hello","now", now);
//    }

}