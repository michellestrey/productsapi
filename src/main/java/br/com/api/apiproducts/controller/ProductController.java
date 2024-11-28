package br.com.api.apiproducts.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.api.apiproducts.model.Product;



@RestController 
@RequestMapping ("products")
public class ProductController {
	
	@PostMapping 
	public Product saveProduct(@RequestBody Product product) {
		System.out.println("Product received! " + product); 
		
		return product;
	}

	
	
	
}
