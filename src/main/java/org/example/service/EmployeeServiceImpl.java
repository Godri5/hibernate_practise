package org.example.service;

import org.example.dao.EmployeeDAO;
import org.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeDAO.deleteEmployee(id);
    }
}
