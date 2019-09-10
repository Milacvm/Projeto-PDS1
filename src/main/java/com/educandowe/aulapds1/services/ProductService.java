package com.educandowe.aulapds1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandowe.aulapds1.entities.Product;
import com.educandowe.aulapds1.repositories.ProductRepository;

@Service 
public class ProductService {
	
    @Autowired
	private ProductRepository repository;
    
    public List <Product> findAll() {
       return repository.findAll();	
    }
    public Product findById(Long Id) {
    	Optional<Product> obj =  repository.findById(Id);
    	return obj.get();
    }
}
