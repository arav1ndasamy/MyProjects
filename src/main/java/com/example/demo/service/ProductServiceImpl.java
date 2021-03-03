package com.example.demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.example.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	private static Map<String, Product> productRepo =new HashMap<>();
	 
	static {
		Product prod1 = new Product();
		prod1.setId("1");
		prod1.setName("Prod1");
		productRepo.put(prod1.getId(), prod1);
		
		Product prod2 = new Product();
		prod2.setId("2");
		prod2.setName("Prod2");
		productRepo.put(prod2.getId(), prod2);
	}
	
	@Override
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		productRepo.put(product.getId(),product);
	}

	@Override
	public void updateProduct(String id, Product product) {
		// TODO Auto-generated method stub
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);
	}

	@Override
	public void deleteProduct(String id) {
		// TODO Auto-generated method stub
		productRepo.remove(id);
	}

	@Override
	public Collection<Product> getProducts() {
		// TODO Auto-generated method stub
		return productRepo.values();
	}

}
