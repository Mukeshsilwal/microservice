package com.Microservices.Order.controller;


import com.Microservices.Order.payload.OrderDto;
import com.Microservices.Order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remote")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<List<OrderDto>> getAllOrder(){
       List<OrderDto> orderDtos=this.orderService.getAllOrder();
       return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Integer id){
        OrderDto orderDto=this.orderService.getOrderById(id);
        return new ResponseEntity<>(orderDto,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Integer id,@RequestBody OrderDto orderDto){
        OrderDto orderDto1=this.orderService.updateOrder(id,orderDto);
        return new ResponseEntity<>(orderDto1,HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto){
        OrderDto orderDto1=this.orderService.createOrder(orderDto);
        return new ResponseEntity<>(orderDto1,HttpStatus.CREATED);

    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id){
        this.orderService.deleteOrder(id);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDto>> getUserByUserId(@PathVariable Integer userId){
        List<OrderDto> order=this.orderService.getUserById(userId);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

}
