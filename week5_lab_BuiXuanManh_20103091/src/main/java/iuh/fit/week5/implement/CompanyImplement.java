package iuh.fit.week5.implement;

import iuh.fit.week5.entities.Company;
import iuh.fit.week5.repositories.CompanyRepository;
import iuh.fit.week5.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyImplement implements CompanyService {
    @Autowired
    private CompanyRepository repository;
    @Override
    public List<Company> getAll() {
        return repository.findAll();
    }
}
