package com.example.basicauthentication.controller;


import com.example.basicauthentication.dao.EmployeeDAO;
import com.example.basicauthentication.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {
    @Autowired
    private EmployeeDAO employeeDAO;
    @GetMapping("/")
    @ResponseBody
    public String welcome() {
        return "Chào mày đến với spring boot";
    }

    @GetMapping(value = "/employees",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<Employee> getEmployees() {
        List<Employee> list = employeeDAO.getAllEmployees();
        return list;
    }


    @GetMapping(value = "/employee/{empNo}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Employee getEmployee(@PathVariable("empNo") String empNo) {
        return employeeDAO.getEmployee(empNo);
    }

    @PostMapping(value = "/employee", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Employee add(@RequestBody Employee employee) {

        System.out.println("create" + employee);
        return employeeDAO.addEmployee(employee);
    }
    @PutMapping(value = "/employee", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Employee edit(@RequestBody Employee employee) {
        System.out.println("Update: " + employee);
        return employeeDAO.updateEmployee(employee);
    }

    @DeleteMapping(value = "/employee/{empNo}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void del(@PathVariable("empNo") String empNo) {
        System.out.println("Delete: " + employeeDAO.getEmployee(empNo));
        employeeDAO.deleteEmployee(empNo);
    }


}
