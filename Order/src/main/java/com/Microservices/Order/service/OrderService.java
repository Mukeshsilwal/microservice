package com.Microservices.Order.service;

import com.Microservices.Order.entity.Order;
import com.Microservices.Order.payload.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto);
    OrderDto updateOrder(Integer id,OrderDto orderDto);
    List<OrderDto> getAllOrder();
    void deleteOrder(Integer id);
    OrderDto getOrderById(Integer id);
    List<OrderDto> getUserById(Integer userId);

}
