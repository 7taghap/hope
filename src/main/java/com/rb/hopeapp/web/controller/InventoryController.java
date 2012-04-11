package com.rb.hopeapp.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.apache.bcel.generic.AllocationInstruction;
import org.pojomatic.Pojomatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.AutoPopulatingList;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.rb.hopeapp.domain.Product;
import com.rb.hopeapp.domain.ProductCategory;
import com.rb.hopeapp.domain.ProductDtl;
import com.rb.hopeapp.domain.UnitConversion;
import com.rb.hopeapp.domain.User;
import com.rb.hopeapp.exception.NoCategoriesException;
import com.rb.hopeapp.exception.NoSuchNameException;
import com.rb.hopeapp.exception.NoSuchStatusException;
import com.rb.hopeapp.exception.ProductNotSaveException;
import com.rb.hopeapp.repository.ProductDao;
import com.rb.hopeapp.repository.UserDao;
import com.rb.hopeapp.service.ProductManager;

@Controller
@SessionAttributes
@RequestMapping("/product")
public class InventoryController {

	private static final Logger logger = Logger
			.getLogger(InventoryController.class);

	@Autowired
	ProductManager productManager;
	
//	@Autowired
//	ServletContext contex;

	List<ProductDtl> productDtls = new AutoPopulatingList(ProductDtl.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView getProducts() {
		String now = (new java.util.Date()).toString();
		logger.info("returning hello view with " + now);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		// User user = userDao.findById(1);
		// logger.info("user :"+ user.getUsername());
		// List<Product> products = this.productManager.getProducts();
		// Product product = this.productManager.getProduct(1000);
		// myModel.put("products", products );
		List<UnitConversion> units = productManager.getUnitConversions();
		myModel.put("units", units);
		return new ModelAndView("product", "model", myModel);
	}

	@RequestMapping(value = "/new.html",method=RequestMethod.GET)
	public String createProduct(ModelMap model) {

		Product product = new Product();

//		productDtls = new AutoPopulatingList(ProductDtl.class);
		ProductDtl dtl = new ProductDtl();
		// dtl.setpr
//		UnitConversion unit = new UnitConversion();
		// productDtls.add(dtl);
		product.setProductDtls(productDtls);
		model.addAttribute("product", product);
		model.addAttribute("productDtl", dtl);
		// model.addAttribute("unit", unit);
		// model.addAttribute("rows",productDtls.size());
		// mav.addObject("product",product);
		return "createProduct";

	}
	

	@RequestMapping(value = "/save.html", method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("product") Product product,@ModelAttribute("productDtl") ProductDtl productdtl,
			BindingResult result, SessionStatus status) throws ProductNotSaveException, NoSuchNameException, NoSuchStatusException{
		product.setProductDtls(productDtls);
		logger.info(product.toString());
		logger.warn("execut product manager save");
		System.out.println("excecute save");
		product = productManager.saveProduct(product);
		logger.info(product.toString());
		return "createProduct";

	}

	@RequestMapping(value = "/addItem.html", method = RequestMethod.POST)
	public String addItemProduct(@ModelAttribute("product") Product product,
			BindingResult result,ModelMap model) {
//		ProductDtl dtl = new ProductDtl();
		logger.info(product.toString());
		ProductDtl productDtl = new ProductDtl();
//		productDtl.setProductDtlName("test");
//		productDtls.add(product);
//		return new ModelAndView("redirect:new");
		model.addAttribute("product", product);
		model.addAttribute("productDtl", productDtl);
		return "createProductDetail";
	}

	@RequestMapping(value = "/deleteItem/{index}.html",method=RequestMethod.GET)
	@ResponseBody
	public String deleteItem(@PathVariable int index,
			HttpServletRequest request) {
		logger.info("index pass :"+ index);
		productDtls.remove(index);
//		logger.info("context path "+ contex.getContextPath());
//		logger.info("context path 2 : " + contex.getServletContextName());
		
//		String redirect = "/hopeapp/product/new";
//		return new ModelAndView(redirect);
		return index+"";
	}

	@RequestMapping(value = "/addItemAjax.html", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ProductDtl addDtlProduct(@ModelAttribute("productDtl")ProductDtl productDtl,
			BindingResult result) {
//		ProductDtl dtl = new ProductDtl();
		logger.info("product Dtl :"+ productDtl.toString());
		productDtls.add(productDtl);
		return productDtl;
	}

	/**
	 * model attributes
	 */

	@ModelAttribute("productCategories")
	public List<String> populateProductCategories()
			throws NoCategoriesException {
		return productManager.getProductCategories();
	}

	@ModelAttribute("unitlist")
	public List<String> populateUnitList() {
		return productManager.getUnitList();
	}
	// @ModelAttribute("productDtls")
	// public List<ProductDtl> initializeProductDtls() {
	// List<ProductDtl> list = new ArrayList<ProductDtl>();
	// ProductDtl productDtl = new ProductDtl();
	// productDtl.setProductDtlName("gamay");
	// return list;
	// }

}
