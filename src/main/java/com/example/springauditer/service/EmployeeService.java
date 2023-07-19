package com.example.springauditer.service;


import java.util.Calendar;

import com.example.springauditer.entity.Employee;
import com.example.springauditer.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public String saveEmployee(Employee request) {
        String currentUser = request.getLoggedInUser();
        request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
        request.setCreatedBy(currentUser);
        employeeRepository.save(request);
        return "Employee saved successfully...";

    }

    public String updateEmployee(int id, double salary, Employee request) {
        Employee employee = employeeRepository.findById(id).get();
        if (employee != null) {
            employee.setSalary(salary);
            employee.setModifiedBy(request.getLoggedInUser());
            employeeRepository.saveAndFlush(employee);
        } else {
            throw new RuntimeException("Employee not found with id : " + id);
        }
        return "Employee Updated successfully ";
    }


    }

