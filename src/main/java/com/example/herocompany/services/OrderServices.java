package com.example.herocompany.services;


import com.example.herocompany.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServices {

   final OrderRepository orderRepository;
    public OrderServices(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }














}
