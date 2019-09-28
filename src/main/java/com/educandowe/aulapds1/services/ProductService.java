package com.educandowe.aulapds1.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandowe.aulapds1.dto.ProductDTO;
import com.educandowe.aulapds1.entities.Product;
import com.educandowe.aulapds1.repositories.ProductRepository;

@Service 
public class ProductService {
	
    @Autowired
	private ProductRepository repository;
    
    public List <ProductDTO> findAll() {
      List <Product> list = repository.findAll();	
      return list.stream().map(e -> new ProductDTO(e)).collect(Collectors.toList());
    }
    public ProductDTO findById(Long Id) {
    	Optional<Product> obj =  repository.findById(Id);
    	Product entity = obj.get();
    	return new ProductDTO(entity);
    }
}
