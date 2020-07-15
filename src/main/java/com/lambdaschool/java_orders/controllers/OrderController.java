package com.lambdaschool.java_orders.controllers;

import com.lambdaschool.java_orders.models.Order;
import com.lambdaschool.java_orders.services.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrdersServices ordersServices;

//    GET /orders/order/{id} - Returns the order and its customer with the given order number
    @GetMapping(value = "/order/{id}", produces = {"application/json"})
    public ResponseEntity<?> getOrderById(@PathVariable long id) {
        Order o = ordersServices.getById(id);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }
//    GET /orders/advanceamount - returns all orders with their customers that have an advanceamount greater than 0.
    @GetMapping(value = "/advanceamount", produces = {"application/json"})
    public ResponseEntity<?> getOrderByAdvanceAmount() {
        List<Order> ordList = ordersServices.getByAdvanceAmount();
        ordList.sort((o1, o2) -> (int) (o1.getAdvanceamount() - o2.getAdvanceamount()));
        return new ResponseEntity<>(ordList, HttpStatus.OK);
    }
//    POST /orders/order - adds a new order to an existing customer

//    PUT /orders/order/{ordernum} - completely replaces the given order record

//    DELETE /orders/order/{ordername} - deletes the given order
}
