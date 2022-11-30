package org.example.service;

import org.example.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer saveCustomer(Customer customer);

    public Customer getCustomer(Long id);

    public void deleteCustomer(Long id);

    public List<Customer> getCustomers();
}
