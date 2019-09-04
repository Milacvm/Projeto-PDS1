package com.educandowe.aulapds1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandowe.aulapds1.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
