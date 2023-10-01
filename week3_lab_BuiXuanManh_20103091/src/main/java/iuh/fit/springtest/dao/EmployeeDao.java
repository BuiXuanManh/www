package iuh.fit.springtest.dao;

import iuh.fit.springtest.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    boolean insert(Employee e);
    boolean update(Employee e);
    List<Employee> getAll();
    Employee findById(int id);
    boolean deleteById(int id);
    int count();
}
