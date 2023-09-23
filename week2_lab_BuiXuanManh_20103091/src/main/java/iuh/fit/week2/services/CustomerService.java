package iuh.fit.week2.services;

import iuh.fit.week2.models.Customer;

import java.util.List;

public interface CustomerService {
    boolean create(Customer customer);
    List<Customer> findAll();
}
