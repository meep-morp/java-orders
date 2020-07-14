package com.lambdaschool.java_orders.services;

import com.lambdaschool.java_orders.models.Customer;
import com.lambdaschool.java_orders.views.OrderCounts;

import java.util.List;

public interface CustomersServices {
    Customer save(Customer customers);
    List<Customer> findAllCustomers();
    Customer findById(Long custid);
    List<Customer> findByLikeNames(String name);
    List<OrderCounts> getOrderCounts();
}
