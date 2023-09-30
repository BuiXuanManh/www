package vn.edu.iuh.fit.backend.implement;

import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.repositories.EmployeeRepository;
import vn.edu.iuh.fit.backend.service.EmployeeService;


import java.util.List;
import java.util.Optional;

public class EmployeeImplement implements EmployeeService {

    private EmployeeRepository repository;

    public EmployeeImplement() {
        repository= new EmployeeRepository();

    }

    @Override
    public boolean create(Employee e) {
        return repository.create(e);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Employee> e = repository.findById(id);
        if (e.isPresent()) {
            if(repository.delete(e.get()))
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Employee em) {
        return repository.update(em);
    }
}
