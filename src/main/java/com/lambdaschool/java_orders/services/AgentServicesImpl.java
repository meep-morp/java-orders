package com.lambdaschool.java_orders.services;

import com.lambdaschool.java_orders.models.Agent;
import com.lambdaschool.java_orders.repositories.AgentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class AgentServicesImpl implements AgentServices {

    @Autowired
    private AgentsRepo agentsrepo;

    @Transactional

    @Override
    public Agent save(Agent agents) {
        return agentsrepo.save(agents);
    }
}
