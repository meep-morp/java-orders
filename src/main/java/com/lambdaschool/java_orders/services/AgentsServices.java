package com.lambdaschool.java_orders.services;

import com.lambdaschool.java_orders.models.Agent;

import java.util.List;

public interface AgentsServices {
    Agent save(Agent agents);

    Agent getById(Long id);

    void deleteUnassigned(long id);

    List<Agent> getUnassigned();
}
