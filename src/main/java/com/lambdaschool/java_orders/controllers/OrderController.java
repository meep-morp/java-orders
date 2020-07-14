package com.lambdaschool.java_orders.controllers;

import com.lambdaschool.java_orders.services.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrdersServices ordersServices;

//    GET /orders/order/{id} - Returns the order and its customer with the given order number

}
