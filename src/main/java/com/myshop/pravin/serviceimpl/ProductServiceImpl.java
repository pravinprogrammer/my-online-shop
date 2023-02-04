package com.myshop.pravin.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.myshop.pravin.entities.Product;
import com.myshop.pravin.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	List<Product> productlist = new ArrayList<>();

	public ProductServiceImpl() {
		productlist.add(new Product(1, "Laptop", 100.00));
		productlist.add(new Product(2, "Mobile", 101.00));
		productlist.add(new Product(3, "Wallet", 102.00));
		productlist.add(new Product(4, "Watch", 103.00));
		productlist.add(new Product(5, "Tablet", 104.00));
	}

	@Override
	public List<Product> getAllProducts() {		
		return productlist;
	}

	/* one of the method
	 * @Override public Product getProductById(Long productId) { for(int
	 * i=0;i<productlist.size();i++) { if(productId == productlist.get(i).getId()) {
	 * return productlist.get(i); } } return null; }
	 */
	
	//second way
	public Product getProductById(Long productId) {
		
		for(Product product : productlist) {
			if(product.getId() == productId) {
				return product;
			}
		}		
		return null;		
	}

	@Override
	public String addProduct(Product product) {
		if(null != product) {
			productlist.add(product);
			return "Product added successfully";
		}
		return null;		
	}

	@Override
	public String updateProuct(Product product) {
		
		/*1st way
		 * for(Product prod : productlist) { if(product.getId() == prod.getId()) {
		 * prod.setName(product.getName()); prod.setPrice(product.getPrice()); return
		 * "Product updated successfully"; } }
		 */			
		
		//second way
		productlist.forEach(e -> {
			if(e.getId() == product.getId()) {
				e.setName(product.getName());
				e.setPrice(product.getPrice());
			}			
		});
		return "product updated ";
	}

	@Override
	public void deleteProduct(Long productId) {		
		productlist = this.productlist.stream().filter(e-> e.getId()!=productId).collect(Collectors.toList());
	}
}
