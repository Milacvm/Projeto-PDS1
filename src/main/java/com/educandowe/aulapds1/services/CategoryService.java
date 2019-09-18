package com.educandowe.aulapds1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandowe.aulapds1.entities.Category;
import com.educandowe.aulapds1.repositories.CategoryRepository;
import com.educandowe.aulapds1.services.exceptions.DatabaseException;
import com.educandowe.aulapds1.services.exceptions.ResourceNotFoundException;

@Service 
public class CategoryService {
	
    @Autowired
	private CategoryRepository repository;
    
    public List <Category> findAll() {
       return repository.findAll();	
    }
    public Category findById(Long Id) {
    	Optional<Category> obj =  repository.findById(Id);
    	return obj.get();
    }
    
    public Category insert (Category obj) {
    	return repository.save(obj);
    }

    public void delete(Long id) {
    	repository.deleteById(id);
    } } catch (EmptyResultDataAccessException e) {
    	throw new ResourceNotFoundException(id);
    } catch (DataIntegrityViolationException e) {
    	throw new DatabaseException(e.getMessage());
}

