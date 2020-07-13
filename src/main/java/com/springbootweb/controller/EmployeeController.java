package com.springbootweb.controller;

import com.springbootweb.dao.DepartmentDao;
import com.springbootweb.dao.EmployeeDao;
import com.springbootweb.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    // 员工dao
    EmployeeDao employeeDao;

    @Autowired
    // 部门dao
    DepartmentDao departmentDao;

    @RequestMapping("/getall")
    String getAll(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("list", all);
        return "emp/list";
    }
    
    @GetMapping("/emp/{id}")
    String getEmployeeById(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp", employee);
        model.addAttribute("departments", departmentDao.getDepartments());
        return  "emp/update";
    }
}
