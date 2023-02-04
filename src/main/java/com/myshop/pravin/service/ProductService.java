package com.myshop.pravin.service;

import java.util.List;

import com.myshop.pravin.entities.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public Product getProductById(Long productId);

	public String addProduct(Product product);

	public String updateProuct(Product product);

	public void deleteProduct(Long productId);
	
}
