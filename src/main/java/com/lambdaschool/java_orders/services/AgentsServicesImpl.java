package com.lambdaschool.java_orders.services;

import com.lambdaschool.java_orders.models.Agent;
import com.lambdaschool.java_orders.models.Customer;
import com.lambdaschool.java_orders.repositories.AgentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

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

    @Override
    public Agent getById(Long id) {
        Agent a = agentsrepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Agent %l does not exist.", id)));
        return a;
    }
}
