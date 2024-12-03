package br.com.api.apiproducts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.apiproducts.model.Product;

public interface ProductRepository extends JpaRepository <Product, String>{
	
	

}
