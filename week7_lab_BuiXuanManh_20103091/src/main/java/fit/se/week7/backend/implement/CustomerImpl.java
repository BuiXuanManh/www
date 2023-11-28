package fit.se.week7.backend.implement;

import fit.se.week7.backend.models.Customer;
import fit.se.week7.backend.repositories.CustomerRepository;
import fit.se.week7.backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;
    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
