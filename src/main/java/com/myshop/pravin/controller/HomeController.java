package com.myshop.pravin.controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.pravin.entities.Product;
import com.myshop.pravin.service.ProductService;
import com.myshop.pravin.serviceimpl.ProductServiceImpl;

@RestController
public class HomeController {
	
	@Autowired
	private ProductService productService; 

	@GetMapping(value = "/home")
	public String Home(Locale locale, Model model) {
		Date date = new Date();
		model.addAttribute(date);
		return "Welcome To Home1";
	}

	@GetMapping(value = "/register")
	public String getUser(Locale locale, Model model) {
		Date date = new Date();
		model.addAttribute(date);
		return "Welcome To Home";
	}
	
	// get all the products
	@GetMapping(value = "/Products")
	public List<Product> getAllProducts() {	
		return this.productService.getAllProducts();
	}
	
	//get a single product by Id
	@GetMapping(value = "/Products/{productId}")
	public Product getProductById(@PathVariable  Long productId) {		
		return this.productService.getProductById(productId);			
	}
	
	//Add a product
	@PostMapping(value = "/Products")
	public String addProduct(@RequestBody  Product product) {		
		String productAdded = this.productService.addProduct(product);		
		return productAdded;		
	}
	
	//update the product
	@PutMapping(value = "/Products")
	public String updateProduct(@RequestBody Product product) {		
		String updateProuct = this.productService.updateProuct(product);		
		return updateProuct;
	}	
	
	//delete the product
	@RequestMapping(value="/Products/{productId}", method=RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long productId) {
	try {
		this.productService.deleteProduct(productId);
		 return new ResponseEntity<>(HttpStatus.OK);
	}catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}	 	
	}	
}
