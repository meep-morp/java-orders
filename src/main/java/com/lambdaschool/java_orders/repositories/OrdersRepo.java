package com.lambdaschool.java_orders.repositories;

import com.lambdaschool.java_orders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepo extends CrudRepository<Order, Long> {
}
