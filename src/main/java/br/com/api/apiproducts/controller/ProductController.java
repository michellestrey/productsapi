package br.com.api.apiproducts.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.apiproducts.model.Product;
import br.com.api.apiproducts.repository.ProductRepository;



@RestController 
@RequestMapping ("products")
public class ProductController {
	
	private ProductRepository productRepository;
	
    public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@PostMapping  //CREATE
	public Product saveProduct(@RequestBody Product product) {
		System.out.println("Product received! " + product); 
		var id = UUID.randomUUID().toString();
		product.setId(id);
		productRepository.save(product);
		return product;
	}
	@GetMapping ("/{id}")  //READ
	public Product findByIdProduct(@PathVariable("id") String id) {
		System.out.println("reading");
		return productRepository.findById(id).orElse(null);
	}
	//delete
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") String id) {
		System.out.println("Deleting");
		productRepository.deleteById(id);
		
		
	}
	@PutMapping ("{id}")                 //UPDATE
	public void updateProduct(@PathVariable ("id") String id,
							  @RequestBody Product product) {
		System.out.println("Updating ---");
		product.setId(id);
		productRepository.save(product);
		
		
	}
	
	
	
}
