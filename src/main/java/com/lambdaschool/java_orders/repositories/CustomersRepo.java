package com.lambdaschool.java_orders.repositories;

import com.lambdaschool.java_orders.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepo extends CrudRepository<Customer, Long> {
}
