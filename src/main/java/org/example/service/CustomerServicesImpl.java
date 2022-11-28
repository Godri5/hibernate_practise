package org.example.service;

import org.example.dao.CustomerDAO;
import org.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServicesImpl implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List < Customer > getCustomers() {
        return customerDAO.getAllCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerDAO.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(Long id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(Long id) {
        customerDAO.deleteCustomer(id);
    }
}
