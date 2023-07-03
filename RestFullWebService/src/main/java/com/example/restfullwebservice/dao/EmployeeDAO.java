package com.example.restfullwebservice.dao;

import com.example.restfullwebservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeDAO {
    private final static Map<String, Employee> map = new HashMap<>();

    static {
        initEmpls();
    }

    public static void initEmpls() {
        Employee emp1 = new Employee("E01", "Smith", "Clerk");
        Employee emp2 = new Employee("E02", "Allen", "Salesman");
        Employee emp3 = new Employee("E03", "Jones", "Manager");

        map.put(emp1.getEmpNo(), emp1);
        map.put(emp2.getEmpNo(), emp2);
        map.put(emp3.getEmpNo(), emp3);
    }
    public Employee getEmployee(String empNo) {
        return map.get(empNo);
    }

    public Employee addEmployee(Employee emp) {
        map.put(emp.getEmpNo(), emp);
        return emp;
    }

    public Employee updateEmployee(Employee emp) {
        map.put(emp.getEmpNo(), emp);
        return emp;
    }

    public void deleteEmployee(String empNo) {
        map.remove(empNo);
    }

    public List<Employee> getAllEmployees() {
        Collection<Employee> c = map.values();
        List<Employee> list = new ArrayList<>();
        list.addAll(c);
        return list;
    }
}
