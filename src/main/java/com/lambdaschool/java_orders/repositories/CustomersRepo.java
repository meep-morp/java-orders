package com.lambdaschool.java_orders.repositories;

import com.lambdaschool.java_orders.models.Customer;
import com.lambdaschool.java_orders.views.OrderCounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersRepo extends CrudRepository<Customer, Long> {
    List<Customer> findByCustnameContainingIgnoringCase(String custname);

    @Query(value = "SELECT c.custname as custname, count(o.ordnum) as countorders " +
            "FROM customers c LEFT JOIN orders o " +
            "ON c.custcode = o.custcode " +
            "GROUP BY c.custname " +
            "ORDER BY countorders desc", nativeQuery = true)
    List<OrderCounts> getOrderCounts();
}
