package fit.se.week7.backend.services;

import fit.se.week7.backend.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> getAll();
    Optional<Customer> findById(Long id);
    Optional<Customer> findByEmail(String email);
}
