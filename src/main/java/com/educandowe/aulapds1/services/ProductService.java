package com.educandowe.aulapds1.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educandowe.aulapds1.dto.CategoryDTO;
import com.educandowe.aulapds1.dto.ProductCategoriesDTO;
import com.educandowe.aulapds1.dto.ProductDTO;
import com.educandowe.aulapds1.entities.Category;
import com.educandowe.aulapds1.entities.Product;
import com.educandowe.aulapds1.repositories.CategoryRepository;
import com.educandowe.aulapds1.repositories.ProductRepository;

@Service 
public class ProductService {
	
    @Autowired
	private ProductRepository repository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List <ProductDTO> findAll() {
      List <Product> list = repository.findAll();	
      return list.stream().map(e -> new ProductDTO(e)).collect(Collectors.toList());
    }
    public ProductDTO findById(Long Id) {
    	Optional<Product> obj =  repository.findById(Id);
    	Product entity = obj.get();
    	return new ProductDTO(entity);
    }
    
    @Transactional
	public ProductDTO insert(ProductCategoriesDTO dto) {
		Product entity = dto.toEntity();
		setProductCategories(entity, dto.getCategories());
		entity = repository.save(entity);
		return new ProductDTO(entity);
		
	}
	
	private void setProductCategories(Product entity, List<CategoryDTO> categories) {
	    entity.getCategories().clear();
		for (CategoryDTO dto : categories) {
			Category category = categoryRepository.getOne(dto.getId());
			entity.getCategories().add(category);
	 }
  }
}
