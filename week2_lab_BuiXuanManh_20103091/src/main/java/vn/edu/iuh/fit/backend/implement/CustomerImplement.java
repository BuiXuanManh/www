package vn.edu.iuh.fit.backend.implement;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.repositories.CustomerRepository;
import vn.edu.iuh.fit.backend.service.CustomerService;


import java.util.List;

public class CustomerImplement implements CustomerService {
    private CustomerRepository repository;

    public CustomerImplement() {
        repository= new CustomerRepository();
    }

    @Override
    public boolean create(Customer customer) {
        return repository.createCust(customer);
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean update(Customer customerDTO) {
        return repository.update(customerDTO);
    }

    @Override
    public Customer findById(Long id) {
        return repository.findById(id);
    }
}
