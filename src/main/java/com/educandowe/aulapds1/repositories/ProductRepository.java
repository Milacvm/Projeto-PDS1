package com.educandowe.aulapds1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandowe.aulapds1.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
