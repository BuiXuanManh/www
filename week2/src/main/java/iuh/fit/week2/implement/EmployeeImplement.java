package iuh.fit.week2.implement;

import iuh.fit.week2.models.Employee;
import iuh.fit.week2.repositories.EmployeeRepository;
import iuh.fit.week2.services.EmployeeService;
import jakarta.inject.Inject;

import java.util.List;

public class EmployeeImplement implements EmployeeService  {
    @Inject
    private EmployeeRepository repository;
    @Override
    public boolean create(Employee e) {
        return repository.create(e);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }
}
