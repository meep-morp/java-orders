package com.lambdaschool.java_orders.services;

import com.lambdaschool.java_orders.models.Order;
import com.lambdaschool.java_orders.repositories.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service(value = "ordersService")
public class OrdersServicesImpl implements OrdersServices {

    @Autowired
    private OrdersRepo ordersrepo;

    @Transactional

    @Override
    public Order save(Order orders) {
        return ordersrepo.save(orders);
    }
}
