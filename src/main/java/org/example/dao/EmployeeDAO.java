package org.example.dao;

import org.example.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Long id);

    public void saveEmployee(Employee employee);

    public void deleteEmployee(Long id);
}
