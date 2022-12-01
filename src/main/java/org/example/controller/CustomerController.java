package org.example.controller;

import java.util.List;

import io.swagger.annotations.Api;
import org.example.model.Customer;
import org.example.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(value = "customer service")
public class CustomerController {

    @Autowired
    private EntityService<Customer> customerService;

    @RequestMapping(value = "/customers/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer) {
        Customer added = customerService.save(customer);
        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return new ResponseEntity<>(customerService.getById(id), HttpStatus.NO_CONTENT);
    }
}