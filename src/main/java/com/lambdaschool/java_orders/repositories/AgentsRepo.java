package com.lambdaschool.java_orders.repositories;

import com.lambdaschool.java_orders.models.Agent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AgentsRepo extends CrudRepository<Agent, Long> {
    List<Agent> findByCustomers_Empty();
}
