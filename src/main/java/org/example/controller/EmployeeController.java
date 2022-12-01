package org.example.controller;

import org.example.model.Employee;
import org.example.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EntityService<Employee> employeeService;

    @RequestMapping(value = "/employees/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
        Employee added = employeeService.save(employee);
        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>(employeeService.getById(id), HttpStatus.NO_CONTENT);
    }
}
