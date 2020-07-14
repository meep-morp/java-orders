package com.lambdaschool.java_orders.services;

import com.lambdaschool.java_orders.models.Agent;
import com.lambdaschool.java_orders.repositories.AgentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "agentsServices")
public class AgentsServicesImpl implements AgentsServices {

    @Autowired
    private AgentsRepo agentsrepo;

    @Transactional

    @Override
    public Agent save(Agent agents) {
        return agentsrepo.save(agents);
    }
}
