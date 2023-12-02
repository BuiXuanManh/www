package fit.se.week7.backend.services;

import fit.se.week7.backend.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    List<Employee> getAll();
    Optional<Employee> findById(Long id);
    Employee save(Employee employee);
}
