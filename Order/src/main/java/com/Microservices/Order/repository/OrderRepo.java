package com.Microservices.Order.repository;

import com.Microservices.Order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Integer> {
List<Order> findByUserId(Integer userId);
}
