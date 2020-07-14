package com.lambdaschool.java_orders.services;

import com.lambdaschool.java_orders.models.Order;
import com.lambdaschool.java_orders.repositories.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;


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

    @Override
    public Order getById(long id) {
        Order o = ordersrepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Order %s does not exist.", id)));
        return o;
    }
}
