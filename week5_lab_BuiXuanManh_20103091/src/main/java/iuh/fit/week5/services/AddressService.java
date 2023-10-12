package iuh.fit.week5.services;

import iuh.fit.week5.entities.Address;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AddressService {
    List<Address> getAll();
    Address save(Address address);
    void delete(Long id);
    String getCountryCode(Long id);
    Optional<Address> find(Long id);
}
