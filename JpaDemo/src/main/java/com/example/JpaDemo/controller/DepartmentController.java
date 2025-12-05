package com.example.JpaDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JpaDemo.entity.Department;
import com.example.JpaDemo.service.DepartmentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }
    
    @PostMapping
    public String createDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
        return "Department created successfully";
    }

    @PutMapping("/update/{id}")
    public String updateDepartment(@PathVariable Long id, @RequestBody Department department){
        departmentService.updateDepartment(id, department);
        return "Department updated successfully";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return "Department deleted successfully";
    }

}
