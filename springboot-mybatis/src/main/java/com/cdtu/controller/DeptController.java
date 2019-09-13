package com.cdtu.controller;

import com.cdtu.bean.Department;
import com.cdtu.bean.Employee;
import com.cdtu.mapper.DeptMapper;
import com.cdtu.mapper.EmployeeMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    DeptMapper deptMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        return deptMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDepartment(Department department) {
        deptMapper.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id) {
        return employeeMapper.getEmpById(id);
    }

    @GetMapping("/emp")
    public void insertEmp(Employee employee) {
        employeeMapper.insertEmp(employee);
    }
//    @GetMapping("/emp/{id}")
//    public  void deleteEmp(@PathVariable("id") Integer id){
//        employeeMapper.deleteEmpById(id);
//    }
//    @GetMapping("/emp")
//    public  void updateEmp(Employee employee){
//        employeeMapper.updateEmp(employee);
//    }
}
