package vn.edu.iuh.fit.backend.service;

import vn.edu.iuh.fit.backend.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    boolean create(Employee e);
    List<Employee> findAll();

    Optional<Employee> findById(Long id);

    boolean delete(Long id);

    boolean update(Employee em);
}
