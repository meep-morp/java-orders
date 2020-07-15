package com.lambdaschool.java_orders.controllers;

import com.lambdaschool.java_orders.models.Agent;
import com.lambdaschool.java_orders.services.AgentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentsServices agentsServices;

    //    GET /agents/agent/{id} - Returns the agent and their customers with the given agent id
    @GetMapping(value = "/agent/{id}", produces = {"application/json"})
    public ResponseEntity<?> getAgentByID(@PathVariable long id) {
        Agent a = agentsServices.getById(id);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

//    DELETE /agents/unassigned/{agentcode} - Deletes an agent if they are not assigned to a customer
    @DeleteMapping(value = "/unassigned/{id}")
    public ResponseEntity<?> deleteUnassignedAgents(@PathVariable long id) {
        agentsServices.deleteUnassigned(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    GET /agents/unassigned - Returns a list of agents with no customers
    @GetMapping(value = "/unassigned", produces = {"application/json"})
    public ResponseEntity<?> getUnassignedAgents() {
        List<Agent> agentList = agentsServices.getUnassigned();
        return new ResponseEntity<>(agentList, HttpStatus.OK);
    }
}
