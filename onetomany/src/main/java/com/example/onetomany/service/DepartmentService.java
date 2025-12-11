package com.example.onetomany.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.onetomany.entity.Department;
import com.example.onetomany.entity.Employee;
import com.example.onetomany.repository.DepartmentRepository;
import com.example.onetomany.repository.EmployeeRepository;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow();
    }

    public Department createDepartment(Department dept) {
        return departmentRepository.save(dept);
    }

    public Department updateDepartment(Long id, Department updatedDept) {
        Department dept = getDepartmentById(id);
        dept.setDeptName(updatedDept.getDeptName());
        dept.setDeptHead(updatedDept.getDeptHead());
        return departmentRepository.save(dept);
    }

    public void deleteDepartment(Long id) {
        Department dept = getDepartmentById(id);
        departmentRepository.delete(dept);
    }

    public Department addEmployeeToDepartment(Long deptId, Employee employee) {
        Department department = getDepartmentById(deptId);
        department.addEmployee(employee);
        return departmentRepository.save(department);
    }

    public Department removeEmployeeFromDepatment(Long deptId, Long empId) {
        Department department = getDepartmentById(deptId);
        Employee employee = employeeRepository.findById(empId).orElseThrow();
        department.removeEmployee(employee);
        return departmentRepository.save(department);
    }
}
