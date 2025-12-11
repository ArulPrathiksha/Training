package com.example.onetomany.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetomany.entity.Department;
import com.example.onetomany.entity.Employee;
import com.example.onetomany.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department dept) {
        return departmentService.createDepartment(dept);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department dept) {
        return departmentService.updateDepartment(id, dept);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }

    @PostMapping("/{deptId}/employees")
    public Department addEmpoyeeToDepartment(@PathVariable("deptId") Long deptId, @RequestBody Employee employee) {
        return departmentService.addEmployeeToDepartment(deptId, employee);
    }

    @DeleteMapping("{deptId}/employees/{empId}")
    public Department removeEmployee(@PathVariable Long deptId, @PathVariable Long empId) {
        return departmentService.removeEmployeeFromDepatment(deptId, empId);
    }
}
