package com.lambdaschool.java_orders.services;


import com.lambdaschool.java_orders.models.Customer;
import com.lambdaschool.java_orders.repositories.CustomersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
