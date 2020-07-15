package com.lambdaschool.java_orders.services;

import com.lambdaschool.java_orders.models.Customer;
import com.lambdaschool.java_orders.models.Order;
import com.lambdaschool.java_orders.models.Payment;
import com.lambdaschool.java_orders.repositories.CustomersRepo;
import com.lambdaschool.java_orders.repositories.OrdersRepo;
import com.lambdaschool.java_orders.repositories.PaymentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Transactional
@Service(value = "ordersService")
public class OrdersServicesImpl implements OrdersServices {

    @Autowired
    private OrdersRepo ordersrepo;

    @Autowired
    private PaymentsRepo paymentsrepos;

    @Autowired
    private CustomersRepo customersrepo;

    @Transactional
    @Override
    public Order save(Order orders) {
        Order newOrd = new Order();

        if (orders.getOrdnum() != 0) {
            ordersrepo.findById(orders.getOrdnum())
                    .orElseThrow(() -> new EntityNotFoundException(String.format("Order %s not found.", orders.getOrdnum())));

            newOrd.setOrdnum(orders.getOrdnum());
        }

        newOrd.setAdvanceamount(orders.getAdvanceamount());
        newOrd.setOrdamount(orders.getOrdamount());
        newOrd.setOrderdescription(orders.getOrderdescription());

        newOrd.setCustomer(customersrepo.findById(orders.getCustomer().getCustcode())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Customer %s not found.", orders.getCustomer().getCustcode()))));

        newOrd.getPayments().clear();
        for (Payment p : orders.getPayments()) {
            Payment newPay = paymentsrepos.findById(p.getPaymentid())
                    .orElseThrow(() -> new EntityNotFoundException(String.format("Payment %s not found.", p.getPaymentid())));
            newOrd.getPayments().add(newPay);
        }

        return ordersrepo.save(newOrd);
    }

    @Override
    public Order getById(long id) {
        Order o = ordersrepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Order %s does not exist.", id)));
        return o;
    }

    @Override
    public List<Order> getByAdvanceAmount() {
        return ordersrepo.findByAdvanceamountGreaterThan(0.0);
    }

    @Transactional
    @Override
    public void delete(String name) {
        ordersrepo.deleteByOrderdescriptionIgnoringCase(name);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        ordersrepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Order %s does not exist.", id)));
        ordersrepo.deleteById(id);
    }
}
