package iuh.fit.week5.services;

import iuh.fit.week5.entities.Company;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CompanyService {
    List<Company> getAll();
}
