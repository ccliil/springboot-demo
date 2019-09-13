package com.cdtu.controller;

import com.cdtu.dao.DepartmentDao;
import com.cdtu.dao.EmployeeDao;
import com.cdtu.entities.Department;
import com.cdtu.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmpController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model) {//查询所有员工返回列表页面
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);//将查询的数据放入请求域
        return "/emp/list";
    }

    @GetMapping("/empadd")
    public String toAddPage(Model model) {//查询所有员工返回列表页面
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);//将查询结果返回页面
        return "emp/add";
    }

    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定，但是请求参数的名字和javaBean入参的对象里面的属性名字必须一致（页面上的每个属性名必须与实体类中的属性名一致）
    @PostMapping("/empsave")
    public String addEmp(Employee employee) {
        System.out.println("保存的员工信息：" + employee);
        employeeDao.save(employee);
        //redirect：表示重定向到一个地址 /代表当前项目路径
        //forward:表示转发到一个地址
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);//将查询结果返回页面
        return "emp/add";
    }

    @PutMapping("/empupdate")
    public String updateEmp(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
