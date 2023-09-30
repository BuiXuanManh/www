package vn.edu.iuh.fit.backend.service;


import vn.edu.iuh.fit.backend.models.Customer;

import java.util.List;

public interface CustomerService {
    boolean create(Customer customer);
    List<Customer> findAll();

    boolean update(Customer customerDTO);

    Customer findById(Long id);
}
