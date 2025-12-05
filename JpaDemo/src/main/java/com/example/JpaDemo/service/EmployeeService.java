package com.example.JpaDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JpaDemo.entity.Employee;
import com.example.JpaDemo.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Long id, Employee employee){
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        System.out.println("Existing Employee: " + existingEmployee);
        if(existingEmployee != null){
            existingEmployee.setName(employee.getName());
            existingEmployee.setDepartment(employee.getDepartment());
            employeeRepository.save(existingEmployee);
        }
    }
    
}
