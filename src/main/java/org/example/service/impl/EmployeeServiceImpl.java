package org.example.service.impl;

import org.example.dao.EntityDAO;
import org.example.model.Employee;
import org.example.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EntityService<Employee> {

    @Autowired
    private EntityDAO<Employee> employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    @Override
    @Transactional
    public Employee save(Employee entity) {
        return employeeDAO.save(entity);
    }

    @Override
    @Transactional
    public Employee getById(Long id) {
        return employeeDAO.getById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        employeeDAO.deleteById(id);
    }
}
