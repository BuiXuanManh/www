package iuh.fit.week2.model;

import iuh.fit.week2.implement.EmployeeImplement;
import iuh.fit.week2.models.Employee;
import iuh.fit.week2.services.EmployeeService;

import java.util.List;
import java.util.Optional;

public class EmployeeModel {
    private EmployeeService service;

    public EmployeeModel() {
        service= new EmployeeImplement();
    }

    public List<Employee> getAllEmployees() {
        return service.findAll();
    }

    public Optional<Employee> getEmployeeById(Long empId) {
        return service.findById(empId);
    }

    public boolean createEmployee(Employee employee) {
        return service.create(employee);
    }

    public boolean updateEmployee(Employee employee) {
        return service.update(employee);
    }

    public boolean deleteEmployee(Long empId) {
        return service.delete(empId);
    }
}
