package org.example.controller;

import java.util.List;

import io.swagger.annotations.Api;
import org.example.model.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(value = "customer service")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listCustomers(Model model) {
        List<Customer> customers = customerService.getCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer) {
        Customer added = customerService.saveCustomer(customer);
        return new ResponseEntity<>(added, HttpStatus.OK);
    }


    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public String deleteCustomer(@RequestParam("id") Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }
}