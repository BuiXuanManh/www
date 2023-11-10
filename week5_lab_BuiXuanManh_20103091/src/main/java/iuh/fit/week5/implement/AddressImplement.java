package iuh.fit.week5.implement;

import iuh.fit.week5.entities.Address;
import iuh.fit.week5.entities.Candidate;
import iuh.fit.week5.repositories.AddressRepository;
import iuh.fit.week5.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AddressImplement implements AddressService {
    @Autowired
    private AddressRepository repository;
    @Override
    public List<Address> getAll() {
        return repository.findAll();
    }

    @Override
    public Address save(Address address) {
        return repository.save(address);
    }


    @Override
    public String getCountryCode(Long id) {
        return repository.getCountryCode(id);
    }

    @Override
    public Optional<Address> find(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<Address> findPage(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort= Sort.by(Sort.Direction.fromString(sortDirection),sortBy);
        Pageable pageable= PageRequest.of(pageNo,pageSize,sort);
        return repository.findAll(pageable);
    }
}
