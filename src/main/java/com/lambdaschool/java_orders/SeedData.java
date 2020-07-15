package com.lambdaschool.java_orders;

import com.github.javafaker.Faker;

import com.lambdaschool.java_orders.models.Agent;
import com.lambdaschool.java_orders.models.Customer;
import com.lambdaschool.java_orders.models.Order;
import com.lambdaschool.java_orders.models.Payment;
import com.lambdaschool.java_orders.repositories.AgentsRepo;
import com.lambdaschool.java_orders.repositories.CustomersRepo;
import com.lambdaschool.java_orders.repositories.OrdersRepo;
import com.lambdaschool.java_orders.repositories.PaymentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Transactional
@Component
public class SeedData implements CommandLineRunner {
    /**
     * Connects the customer table to this SeedData method
     */
    @Autowired
    private CustomersRepo customersrepo;

    /**
     * Connects the agents table to this SeedData method
     */
    @Autowired
    private AgentsRepo agentsrepo;

    /**
     * Connects the orders table to this SeedData method
     */
    @Autowired
    private OrdersRepo ordersrepo;

    /**
     * Connects the payment table to this SeedData method
     */
    @Autowired
    private PaymentsRepo paymentrepos;

    /**
     * Generates test, seed data for our application
     * First a set of known data is seeded into our database.
     * Second a random set of data using Java Faker is seeded into our database.
     * Note this process does not remove data from the database. So if data exists in the database
     * prior to running this process, that data remains in the database.
     *
     * @param args The parameter is required by the parent interface but is not used in this process.
     */
    @Transactional
    @Override
    public void run(String[] args) throws Exception {

        agentsrepo.deleteAll();
        paymentrepos.deleteAll();

        Payment pay1 = new Payment("Cash");
        Payment pay2 = new Payment("Gift Card");
        Payment pay3 = new Payment("Credit Card");
        Payment pay4 = new Payment("Mobile Pay");

        pay1 = paymentrepos.save(pay1);
        pay2 = paymentrepos.save(pay2);
        pay3 = paymentrepos.save(pay3);
        pay4 = paymentrepos.save(pay4);

        Faker faker = new Faker();
        List<Agent> agentFakers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            agentFakers.add(new Agent(
                    faker.name().firstName(),
                    faker.address().country(),
                    faker.number().randomDouble(2, 1, 0),
                    faker.phoneNumber().cellPhone(),
                    faker.address().cityPrefix()
            ));
        }

        for (Agent agent : agentFakers) {
            agentsrepo.save(agent);
        }

        Agent a01 = new Agent("Ramasundar",
                "Bangalore",
                0.15,
                "077-25814763",
                "");
        Agent a02 = new Agent("Alex",
                "London",
                0.13,
                "075-12458969",
                "");
        Agent a03 = new Agent("Alford",
                "New York",
                0.12,
                "044-25874365",
                "");
        Agent a04 = new Agent("Ravi",
                "Bangalore",
                0.15,
                "077-45625874",
                "");
        Agent a05 = new Agent("Santakumar",
                "Chennai",
                0.14,
                "007-22388644",
                "");
        Agent a06 = new Agent("Lucida",
                "San Jose",
                0.12,
                "044-52981425",
                "");
        Agent a07 = new Agent("Anderson",
                "Brisban",
                0.13,
                "045-21447739",
                "");
        Agent a08 = new Agent("Subbarao",
                "Bangalore",
                0.14,
                "077-12346674",
                "");
        Agent a09 = new Agent("Mukesh",
                "Mumbai",
                0.11,
                "029-12358964",
                "");
        Agent a10 = new Agent("McDen",
                "London",
                0.15,
                "078-22255588",
                "");
        Agent a11 = new Agent("Ivan",
                "Torento",
                0.15,
                "008-22544166",
                "");
        Agent a12 = new Agent("Benjamin",
                "Hampshair",
                0.11,
                "008-22536178",
                "");

        List<Customer> customerFakers = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            customerFakers.add(new Customer(
                    faker.name().lastName(),
                    faker.address().city(),
                    faker.address().state(),
                    faker.address().country(),
                    String.valueOf(faker.number().numberBetween(1, 12)),
                    faker.number().randomDouble(2, 2, 200000),
                    faker.number().randomDouble(2, 2, 200000),
                    faker.number().randomDouble(2, 2, 200000),
                    faker.number().randomDouble(2, 2, 200000),
                    faker.phoneNumber().cellPhone(),
                    agentFakers.get(faker.number().numberBetween(0, agentFakers.size() - 1))
            ));
        }

        for (Customer customer : customerFakers) {
            customersrepo.save(customer);
        }

        Customer c01 = new Customer("Holmes",
                "London",
                "London",
                "UK",
                "2",
                6000.00,
                5000.00,
                7000.00,
                4000.00,
                "BBBBBBB",
                a03);
        Customer c02 = new Customer(
                "Micheal",
                "New York",
                "New York",
                "USA",
                "2",
                3000.00,
                5000.00,
                2000.00,
                6000.00,
                "CCCCCCC",
                a08);
        Customer c03 = new Customer("Albert",
                "New York",
                "New York",
                "USA",
                "3",
                5000.00,
                7000.00,
                6000.00,
                6000.00,
                "BBBBSBB",
                a08);
        Customer c04 = new Customer("Ravindran",
                "Bangalore",
                "Bangalore",
                "India",
                "2",
                5000.00,
                7000.00,
                4000.00,
                8000.00,
                "AVAVAVA",
                a11);
        Customer c05 = new Customer("Cook",
                "London",
                "London",
                "UK",
                "2",
                4000.00,
                9000.00,
                7000.00,
                6000.00,
                "FSDDSDF",
                a06);
        Customer c06 = new Customer("Stuart",
                "London",
                "London",
                "UK",
                "1",
                6000.00,
                8000.00,
                3000.00,
                11000.00,
                "GFSGERS",
                a03);
        Customer c07 = new Customer("Bolt",
                "New York",
                "New York",
                "USA",
                "3",
                5000.00,
                7000.00,
                9000.00,
                3000.00,
                "DDNRDRH",
                a08);
        Customer c08 = new Customer("Fleming",
                "Brisban",
                "Brisban",
                "Australia",
                "2",
                7000.00,
                7000.00,
                9000.00,
                5000.00,
                "NHBGVFC",
                a05);
        Customer c09 = new Customer("Jacks",
                "Brisban",
                "Brisban",
                "Australia",
                "1",
                7000.00,
                7000.00,
                7000.00,
                7000.00,
                "WERTGDF",
                a05);
        Customer c10 = new Customer("Yearannaidu",
                "Chennai",
                "Chennai",
                "India",
                "1",
                8000.00,
                7000.00,
                7000.00,
                8000.00,
                "ZZZZBFV",
                a10);
        Customer c11 = new Customer("Sasikant",
                "Mumbai",
                "Mumbai",
                "India",
                "1",
                7000.00,
                11000.00,
                7000.00,
                11000.00,
                "147-25896312",
                a02);
        Customer c12 = new Customer("Ramanathan",
                "Chennai",
                "Chennai",
                "India",
                "1",
                7000.00,
                11000.00,
                9000.00,
                9000.00,
                "GHRDWSD",
                a10);
        Customer c13 = new Customer("Avinash",
                "Mumbai",
                "Mumbai",
                "India",
                "2",
                7000.00,
                11000.00,
                9000.00,
                9000.00,
                "113-12345678",
                a02);
        Customer c14 = new Customer("Winston",
                "Brisban",
                "Brisban",
                "Australia",
                "1",
                5000.00,
                8000.00,
                7000.00,
                6000.00,
                "AAAAAAA",
                a05);
        Customer c15 = new Customer("Karl",
                "London",
                "London",
                "UK",
                "0",
                4000.00,
                6000.00,
                7000.00,
                3000.00,
                "AAAABAA",
                a06);
        Customer c16 = new Customer("Shilton",
                "Torento",
                "Torento",
                "Canada",
                "1",
                10000.00,
                7000.00,
                6000.00,
                11000.00,
                "DDDDDDD",
                a04);
        Customer c17 = new Customer("Charles",
                "Hampshair",
                "Hampshair",
                "UK",
                "3",
                6000.00,
                4000.00,
                5000.00,
                5000.00,
                "MMMMMMM",
                a09);
        Customer c18 = new Customer("Srinivas",
                "Bangalore",
                "Bangalore",
                "India",
                "2",
                8000.00,
                4000.00,
                3000.00,
                9000.00,
                "AAAAAAB",
                a07);
        Customer c19 = new Customer("Steven",
                "San Jose",
                "San Jose",
                "USA",
                "1",
                5000.00,
                7000.00,
                9000.00,
                3000.00,
                "KRFYGJK",
                a10);
        Customer c20 = new Customer("Karolina",
                "Torento",
                "Torento",
                "Canada",
                "1",
                7000.00,
                7000.00,
                9000.00,
                5000.00,
                "HJKORED",
                a04);
        Customer c21 = new Customer("Martin",
                "Torento",
                "Torento",
                "Canada",
                "2",
                8000.00,
                7000.00,
                7000.00,
                8000.00,
                "MJYURFD",
                a04);
        Customer c22 = new Customer("Ramesh",
                "Mumbai",
                "Mumbai",
                "India",
                "3",
                8000.00,
                7000.00,
                3000.00,
                12000.00,
                "Phone No",
                a02);
        Customer c23 = new Customer("Rangarappa",
                "Bangalore",
                "Bangalore",
                "India",
                "2",
                8000.00,
                11000.00,
                7000.00,
                12000.00,
                "AAAATGF",
                a01);
        Customer c24 = new Customer("Venkatpati",
                "Bangalore",
                "Bangalore",
                "India",
                "2",
                8000.00,
                11000.00,
                7000.00,
                12000.00,
                "JRTVFDD",
                a07);
        Customer c25 = new Customer("Sundariya",
                "Chennai",
                "Chennai",
                "India",
                "3",
                7000.00,
                11000.00,
                7000.00,
                11000.00,
                "PPHGRTS",
                a10);

        List<Order> orderFakers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            orderFakers.add(new Order(
                    faker.number().randomDouble(2, 2, 3000),
                    faker.number().randomDouble(2, 2, 3000),
                    customerFakers.get(faker.number().numberBetween(0, customerFakers.size() - 1)),
                    faker.starTrek().character()
            ));
        }

        for (Order order : orderFakers) {
            order.addPayments(pay1);
            ordersrepo.save(order);
        }

        Order o01 = new Order(
                1000.00,
                600.00,
                c13,
                "SOD");
        o01.addPayments(pay1);

        Order o02 = new Order(3000.00,
                500.00,
                c19,
                "SOD");
        o02.addPayments(pay2);

        Order o03 = new Order(4500.00,
                900.00,
                c07,
                "SOD");
        o03.addPayments(pay3);
        o03.addPayments(pay2);

        Order o04 = new Order(2000.00,
                0.00,
                c16,
                "SOD");
        o04.addPayments(pay4);

        Order o05 = new Order(4000.00,
                600.00,
                c22,
                "SOD");
        o05.addPayments(pay2);

        Order o06 = new Order(2000.00,
                0.00,
                c12,
                "SOD");
        o06.addPayments(pay3);

        Order o07 = new Order(3500.00,
                2000.00,
                c02,
                "SOD");
        o07.addPayments(pay4);

        Order o08 = new Order(2500.00,
                400.00,
                c03,
                "SOD");
        o08.addPayments(pay1);

        Order o09 = new Order(500.00,
                0.00,
                c23,
                "SOD");
        o09.addPayments(pay3);

        Order o10 = new Order(4000.00,
                700.00,
                c07,
                "SOD");
        o10.addPayments(pay4);

        Order o11 = new Order(1500.00,
                600.00,
                c08,
                "SOD");
        o11.addPayments(pay2);

        Order o12 = new Order(2500.00,
                0.00,
                c25,
                "SOD");
        o12.addPayments(pay1);

        agentsrepo.save(a01);
        agentsrepo.save(a02);
        agentsrepo.save(a03);
        agentsrepo.save(a04);
        agentsrepo.save(a05);
        agentsrepo.save(a06);
        agentsrepo.save(a07);
        agentsrepo.save(a08);
        agentsrepo.save(a09);
        agentsrepo.save(a10);
        agentsrepo.save(a11);
        agentsrepo.save(a12);

        customersrepo.save(c01);
        customersrepo.save(c02);
        customersrepo.save(c03);
        customersrepo.save(c04);
        customersrepo.save(c05);
        customersrepo.save(c06);
        customersrepo.save(c07);
        customersrepo.save(c08);
        customersrepo.save(c09);
        customersrepo.save(c10);
        customersrepo.save(c11);
        customersrepo.save(c12);
        customersrepo.save(c13);
        customersrepo.save(c14);
        customersrepo.save(c15);
        customersrepo.save(c16);
        customersrepo.save(c17);
        customersrepo.save(c18);
        customersrepo.save(c19);
        customersrepo.save(c20);
        customersrepo.save(c21);
        customersrepo.save(c22);
        customersrepo.save(c23);
        customersrepo.save(c24);
        customersrepo.save(c25);

        ordersrepo.save(o01);
        ordersrepo.save(o02);
        ordersrepo.save(o03);
        ordersrepo.save(o04);
        ordersrepo.save(o05);
        ordersrepo.save(o06);
        ordersrepo.save(o07);
        ordersrepo.save(o08);
        ordersrepo.save(o09);
        ordersrepo.save(o10);
        ordersrepo.save(o11);
        ordersrepo.save(o12);
    }
}