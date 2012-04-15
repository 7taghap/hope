package com.rb.hopeapp.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.Context;
import javax.persistence.AttributeOverride;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.apache.bcel.generic.AllocationInstruction;
import org.hibernate.Hibernate;
import org.pojomatic.Pojomatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
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
import com.rb.hopeapp.repository.ProductCategoryDao;
import com.rb.hopeapp.repository.ProductDao;
import com.rb.hopeapp.repository.StatusDao;
import com.rb.hopeapp.repository.UnitConversionDao;
import com.rb.hopeapp.repository.UserDao;
import com.rb.hopeapp.service.ProductManager;
import com.rb.hopeapp.service.impl.ProductManagerImpl;

@Controller
@SessionAttributes
@RequestMapping("/product")
public class InventoryController {

	private static final Logger logger = Logger
			.getLogger(InventoryController.class);

	@Autowired
	@Qualifier("productService")
	ProductManager productService;
	

	List<ProductDtl> productDtls = new AutoPopulatingList(ProductDtl.class);

	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public ModelAndView getProducts(@ModelAttribute("p")String p) {
		Map<String, Object> myModel = new HashMap<String, Object>();

		List<ProductDtl> products = productService.getProductDtls();
		logger.info("p value :"+ p);
		PagedListHolder<ProductDtl> productList = new PagedListHolder<ProductDtl>(products);
		try{
			productList.setPage(Integer.parseInt(p));
		
		}catch(NumberFormatException nfe) {
			logger.info(nfe.getMessage());
		}
		productList.setPageSize(2);
//		myModel.put("products", productList);
//		myModel.put("pagedListHolder", productList);
		
//		Hibernate.initialize(products.get(index))
		return new ModelAndView("paging", "pagedListHolder", productList);
	}
	

	@RequestMapping(value = "/new.html",method=RequestMethod.GET)
	public String createProduct(ModelMap model) {
		Product product = new Product();
		ProductDtl dtl = new ProductDtl();
		product.setProductDtls(productDtls);
		model.addAttribute("product", product);
		model.addAttribute("productDtl", dtl);
		return "createProduct";

	}
	

	@RequestMapping(value = "/save.html", method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("product") Product product,@ModelAttribute("productDtl") ProductDtl productdtl,
			BindingResult result, SessionStatus status) throws ProductNotSaveException, NoSuchNameException, NoSuchStatusException{
		product.setProductDtls(productDtls);
		logger.info(product.toString());
		logger.warn("execut product manager save");
		System.out.println("excecute save");
		product = productService.saveProduct(product);
//		product = productDao.saveProduct(product);
		logger.info(product.toString());
		return "createProduct";

	}

	@RequestMapping(value = "/addItem.html", method = RequestMethod.POST)
	public String addItemProduct(@ModelAttribute("product") Product product,
			BindingResult result,ModelMap model) {
		logger.info(product.toString());
		ProductDtl productDtl = new ProductDtl();
		model.addAttribute("product", product);
		model.addAttribute("productDtl", productDtl);
		return "createProductDetail";
	}

	
	/******************************** AJAX REQUEST *******************************/
	
	@RequestMapping(value = "/deleteItem/{index}.html",method=RequestMethod.GET)
	@ResponseBody
	public String deleteItem(@PathVariable int index,
			HttpServletRequest request) {
		logger.info("index pass :"+ index);
		productDtls.remove(index);

		return index+"";
	}

	@RequestMapping(value = "/addItemAjax.html", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ProductDtl addDtlProduct(@ModelAttribute("productDtl")ProductDtl productDtl,
			BindingResult result) {

		logger.info("product Dtl :"+ productDtl.toString());
		productDtls.add(productDtl);
		return productDtl;
	}
	
	@RequestMapping(value="/totalQty.html", method=RequestMethod.POST,
			produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public String getProductTotalQtyOnHand(@ModelAttribute("product") Product product,
			BindingResult result) throws NoSuchNameException {
		String qtyOnHand = "";
		if (product.getProductDtls()==null) {
			product.setProductDtls(productDtls);
		}
		 double qty = productService.computeProductTotalQtyOnHand(product);
		 qtyOnHand = qty+"";
		return qtyOnHand;
	}

	/**
	 * model attributes
	 */

	@ModelAttribute("productCategories")
	public List<String> populateProductCategories()
			throws NoCategoriesException {
		return productService.getProductCategories();

	}

	@ModelAttribute("unitlist")
	public List<String> populateUnitList() {
		return productService.getUnitList();
	}
	

}
