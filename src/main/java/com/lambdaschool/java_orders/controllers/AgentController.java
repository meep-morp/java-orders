package com.lambdaschool.java_orders.controllers;

import com.lambdaschool.java_orders.services.AgentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentsServices agentsServices;

//    GET /agents/agent/{id} - Returns the agent and their customers with the given agent id
}
