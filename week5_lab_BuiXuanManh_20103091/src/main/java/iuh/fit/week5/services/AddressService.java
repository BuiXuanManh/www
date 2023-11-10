package iuh.fit.week5.services;

import iuh.fit.week5.entities.Address;
import iuh.fit.week5.entities.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AddressService {
    List<Address> getAll();
    Address save(Address address);
    String getCountryCode(Long id);
    Optional<Address> find(Long id);
    Page<Address> findPage(int pageNo, int pageSize,String sortBy,String sortDirection);
}
