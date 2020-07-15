package com.lambdaschool.java_orders.services;

import com.lambdaschool.java_orders.models.Order;

import java.util.List;

public interface OrdersServices {
    Order save(Order orders);

    Order getById(long id);

    List<Order> getByAdvanceAmount();

    void delete(String name);

    void deleteById(long id);
}
