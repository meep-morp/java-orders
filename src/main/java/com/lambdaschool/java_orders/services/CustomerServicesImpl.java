package com.lambdaschool.java_orders.services;


import com.lambdaschool.java_orders.models.Customer;
import com.lambdaschool.java_orders.repositories.CustomersRepo;
import com.lambdaschool.java_orders.views.OrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customersService")
public class CustomerServicesImpl implements CustomersServices {

    @Autowired
    private CustomersRepo customersrepo;

    @Transactional

    @Override
    public Customer save(Customer customers) {
        return customersrepo.save(customers);
    }

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> custList = new ArrayList<>();

        customersrepo.findAll().iterator().forEachRemaining(custList::add);
        return custList;
    }

    @Override
    public Customer findById(Long custid) {
        Customer c = customersrepo.findById(custid)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Customer %s does not exist.", custid)));
        return c;
    }

    @Override
    public List<Customer> findByLikeNames(String name) {
        return customersrepo.findByCustnameContainingIgnoringCase(name);
    }

    @Override
    public List<OrderCounts> getOrderCounts() {
        return customersrepo.getOrderCounts();
    }
}
