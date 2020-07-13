package com.lambdaschool.java_orders.repositories;

import com.lambdaschool.java_orders.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentsRepo extends CrudRepository<Agent, Long> {
}
