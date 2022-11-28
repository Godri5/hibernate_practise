package org.example.controller;

import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employee", employees);
        return "list-employees";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @PostMapping("/saveEmployee")
    public String saveCustomer(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee/list";
    }
}
