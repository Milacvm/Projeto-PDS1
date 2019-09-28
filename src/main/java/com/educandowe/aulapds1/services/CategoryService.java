package com.educandowe.aulapds1.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educandowe.aulapds1.dto.CategoryDTO;
import com.educandowe.aulapds1.entities.Category;
import com.educandowe.aulapds1.repositories.CategoryRepository;
import com.educandowe.aulapds1.services.exceptions.ResourceNotFoundException;

@Service 
public class CategoryService {
	
    @Autowired
	private CategoryRepository repository;
    
    public List <CategoryDTO> findAll() {
       List<Category> list = repository.findAll();	
       return list.stream().map(e -> new CategoryDTO(e)).collect(Collectors.toList());
    }
    public CategoryDTO findById(Long id) {
    	Optional<Category> obj =  repository.findById(id);
    	Category entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
        return new CategoryDTO(entity);
    }
    
    public CategoryDTO insert(CategoryDTO dto) {
    	Category entity = dto.toEntity();
    	entity = repository.save(entity);
    	return new CategoryDTO (entity);
    }  
    
    public void delete (Long id) {
    	repository.deleteById(id);
    }
    
    @Transactional
    public CategoryDTO update (Long id, CategoryDTO dto) {
    	Category entity = repository.getOne(id);
    	updateData (entity, dto);
    	entity = repository.save(entity);
    	return new CategoryDTO(entity);
    }
	private void updateData(Category entity, CategoryDTO dto) {
		entity.setName (dto.getName());		
	}
}

