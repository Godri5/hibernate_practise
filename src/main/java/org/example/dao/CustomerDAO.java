package org.example.dao;

import org.example.model.Customer;

import java.util.List;

public interface CustomerDAO{
    public void saveCustomer(Customer customer);

    public Customer getCustomer(Long id);

    public void deleteCustomer(Long id);

    public List<Customer> getAllCustomers();
}
