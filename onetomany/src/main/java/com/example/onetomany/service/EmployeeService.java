package com.example.onetomany.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.onetomany.entity.Employee;
import com.example.onetomany.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    public Employee createEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    public Employee updateEmployee(Long id, Employee updatedEmp) {
        Employee emp = getEmployeeById(id);
        emp.setEmpName(updatedEmp.getEmpName());
        emp.setExperience(updatedEmp.getExperience());
        return employeeRepository.save(emp);
    }

    public void deleteEmployee(Long id) {
        Employee emp = getEmployeeById(id);
        employeeRepository.delete(emp);
    }
}
