package iuh.fit.week2.implement;

import iuh.fit.week2.models.Customer;
import iuh.fit.week2.repositories.CustomerRepository;
import iuh.fit.week2.services.CustomerService;


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
}
