package com.lambdaschool.java_orders.services;

import com.lambdaschool.java_orders.models.Payment;
import com.lambdaschool.java_orders.repositories.PaymentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "paymentService")
public class PaymentsServicesImpl implements PaymentsServices {

    @Autowired
    private PaymentsRepo paymentsrepo;

    @Transactional

    @Override
    public Payment save(Payment payments) {
        return paymentsrepo.save(payments);
    }
}
