package com.example.JpaDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JpaDemo.entity.Employee;
import com.example.JpaDemo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    
    @PostMapping
    public String createEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return "Employee created successfully";
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employeeService.updateEmployee(id, employee);
        return "Employee updated successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}
