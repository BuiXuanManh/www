package iuh.fit.week2.implement;

import iuh.fit.week2.models.Employee;
import iuh.fit.week2.repositories.EmployeeRepository;
import iuh.fit.week2.services.EmployeeService;


import java.util.List;
import java.util.Optional;

public class EmployeeImplement implements EmployeeService  {

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
