package com.Microservices.Order.service.serviceImpl;

import com.Microservices.Order.entity.Order;
import com.Microservices.Order.entity.User;
import com.Microservices.Order.payload.OrderDto;
import com.Microservices.Order.repository.OrderRepo;
import com.Microservices.Order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final ModelMapper modelMapper;
    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order=this.mapToOrder(orderDto);
        Order order1=this.orderRepo.save(order);
        return mapToDto(order1);
    }

    @Override
    public OrderDto updateOrder(Integer id, OrderDto orderDto) {
        Order order=this.orderRepo.findById(id).orElseThrow();
        Order order1=this.mapToOrder(orderDto);
        order1.setOrderName(order.getOrderName());
        order1.setOrderNo(order.getOrderNo());
        Order order2=this.orderRepo.save(order1);
        return mapToDto(order2);
    }

    @Override
    public List<OrderDto> getAllOrder() {
        List<Order> orders=this.orderRepo.findAll();
        List<OrderDto> orderDtos=orders.stream().map((order)->this.mapToDto(order)).collect(Collectors.toList());

    return orderDtos;
    }

    @Override
    public void deleteOrder(Integer id) {
        this.orderRepo.deleteById(id);

    }

    @Override
    public OrderDto getOrderById(Integer id) {
        Order order=this.orderRepo.findById(id).orElseThrow();
        return mapToDto(order);
    }

    @Override
    public List<OrderDto> getUserById(Integer userId) {
        List<Order> orders=this.orderRepo.findByUserId(userId);
        List<OrderDto> orderDtos=orders.stream().map((order)->this.mapToDto(order)).collect(Collectors.toList());
        return orderDtos;
    }
    public Order mapToOrder(OrderDto orderDto){
        Order order=this.modelMapper.map(orderDto, Order.class);
        return order;
    }
    public OrderDto mapToDto(Order order){
        OrderDto orderDto=this.modelMapper.map(order, OrderDto.class);
        return orderDto;
    }


//    @Override
//    public List<Order> getUserByUserId(Integer userId) {
//        List<Order> order=this.orderRepo.findByUserId(userId);
//        return order;
//    }
}
