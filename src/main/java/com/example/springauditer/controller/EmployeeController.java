package com.example.springauditer.controller;

import com.example.springauditer.entity.Employee;
import com.example.springauditer.exception.EmployeeNotFoundException;
import com.example.springauditer.repository.EmployeeRepository;
import com.example.springauditer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController

@RequestMapping(value = "employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/addEmployee")
    public String saveEmployee(@RequestBody Employee request) {
        return service.saveEmployee(request);
    }
    @PutMapping("/updateEmployee/{id}/{salary}")
    public String updateEmployeeSalary(@PathVariable int id, @PathVariable double salary,
                                       @RequestBody Employee request) {
        return service.updateEmployee(id, salary, request);
    }


    @DeleteMapping("delete/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
    }

}


