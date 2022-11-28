package org.example.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.model.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Operation(summary = "Gets all customers", tags = "customer")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the customers",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Customer.class)))
                    })
    })
    @GetMapping("/list")
    public String listCustomers(Model model) {
        List <Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "list-customers";
    }

    @Operation(summary = "Shows adding form", tags = "customer")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Shows the form",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    })
    })
    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @Operation(summary = "Add or update the customer", tags = "customer")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Shows all of the customers with updated/new one",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Customer.class)))
                    })
    })
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @Operation(summary = "Shows update form", tags = "customer")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Shows the form",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    })
    })
    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("id") Long id, Model model) {
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @Operation(summary = "Delete the customer", tags = "customer")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Shows all of the customers",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Customer.class)))
                    })
    })
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }
}