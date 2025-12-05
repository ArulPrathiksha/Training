package com.example.JpaDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JpaDemo.entity.Department;
import com.example.JpaDemo.repository.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public void saveDepartment(Department department){
        departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }

    public void updateDepartment(Long id, Department department){
        Department existingDepartment = departmentRepository.findById(id).orElse(null);
        if(existingDepartment != null){
            existingDepartment.setName(department.getName());
            existingDepartment.setEmployees(department.getEmployees());
            departmentRepository.save(existingDepartment);
        }
    }
}

