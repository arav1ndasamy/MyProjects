package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
@RestController
public class ProductServiceController {
	@Autowired
	ProductService productService;

	//get
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<Object> getProduct() {
	   return new ResponseEntity<>(productService.getProducts() , HttpStatus.OK);
	}
	
	//post
	@RequestMapping(value="/products", method= RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product){
		productService.createProduct(product);
		return new ResponseEntity<>("Product is created",HttpStatus.CREATED);
	}
	
	//put
	@RequestMapping(value="/products/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
		productService.updateProduct(id, product);
		return new ResponseEntity<>("Product is updated", HttpStatus.OK);
	}
	
	//delete
	@RequestMapping(value ="/products/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id ){
		productService.deleteProduct(id);
		return new ResponseEntity<>("Product is deleted", HttpStatus.OK);
	}

}
