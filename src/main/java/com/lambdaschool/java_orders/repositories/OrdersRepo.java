package com.lambdaschool.java_orders.repositories;

import com.lambdaschool.java_orders.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepo extends CrudRepository<Order, Long> {

    List<Order> findByAdvanceamountGreaterThan(double amount);

}
