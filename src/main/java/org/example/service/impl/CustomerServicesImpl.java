package org.example.service.impl;

import org.example.dao.EntityDAO;
import org.example.model.Customer;
import org.example.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServicesImpl implements EntityService<Customer> {

    @Autowired
    private EntityDAO<Customer> customerDAO;

    @Override
    @Transactional
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    @Override
    @Transactional
    public Customer save(Customer entity) {
        customerDAO.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public Customer getById(Long id) {
        return customerDAO.getById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        customerDAO.deleteById(id);
    }
}
