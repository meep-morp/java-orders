package com.lambdaschool.java_orders.repositories;

import com.lambdaschool.java_orders.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentsRepo extends CrudRepository<Payment, Long> {
}
