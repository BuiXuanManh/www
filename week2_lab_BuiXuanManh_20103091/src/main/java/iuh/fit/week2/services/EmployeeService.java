package iuh.fit.week2.services;

import iuh.fit.week2.models.Employee;

import java.util.List;

public interface EmployeeService {
    boolean create(Employee e);
    List<Employee> findAll();
}
