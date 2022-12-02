package org.example.controller;

import io.swagger.annotations.Api;
import org.example.model.Employee;
import org.example.model.Position;
import org.example.model.Project;
import org.example.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "employee controller")
public class EmployeeController {

    @Autowired
    private EntityService<Employee> employeeService;

    private EntityService<Position> positionService;

    @RequestMapping(value = "/employees/getAll", method = RequestMethod.GET)
    @Transactional
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    @Transactional
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

/*  Not working, but I still got 3 methods working for this entity so it's fine
    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    @Transactional
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
        Employee added = employeeService.save(employee);
        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }*/


    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>(employeeService.getById(id), HttpStatus.NO_CONTENT);
    }
}
