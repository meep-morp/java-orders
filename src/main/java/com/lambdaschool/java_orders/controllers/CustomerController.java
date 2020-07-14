package com.lambdaschool.java_orders.controllers;

import com.lambdaschool.java_orders.models.Customer;
import com.lambdaschool.java_orders.services.CustomersServices;
import com.lambdaschool.java_orders.views.OrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomersServices customersServices;

//    GET /customers/orders - Returns all customers with their orders
    @GetMapping(value = "/orders", produces = {"application/json"})
    public ResponseEntity<?> getAllCustomersAndOrders() {
        List<Customer> custList = customersServices.findAllCustomers();
        return new ResponseEntity<>(custList, HttpStatus.OK);
    }

//    GET /customers/customer/{id} - Returns the customer and their orders with the given customer id
    @GetMapping(value = "/customer/{custid}", produces = {"application/json"})
    public ResponseEntity<?> getCustomerById(@PathVariable long custid) {
        Customer c = customersServices.findById(custid);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
//    GET /customers/namelike/{likename} - Returns all customers and their orders with a customer name containing the given substring
    @GetMapping(value = "/namelike/{likenames}", produces = {"application/json"})
    public ResponseEntity<?> getByLikeNames(@PathVariable String likenames) {
        List<Customer> custList = customersServices.findByLikeNames(likenames);
        return new ResponseEntity<>(custList, HttpStatus.OK);
    }

//    GET /customers/orders/count - Using a custom query, return a list of all customers with the number of orders they have placed.
    @GetMapping(value = "/orders/count", produces = {"application/json"})
    public ResponseEntity<?> getByOrderCount() {
        List<OrderCounts> custList = customersServices.getOrderCounts();
        return new ResponseEntity<>(custList, HttpStatus.OK);
    }
}
