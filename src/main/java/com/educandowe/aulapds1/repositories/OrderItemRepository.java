package com.educandowe.aulapds1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandowe.aulapds1.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
