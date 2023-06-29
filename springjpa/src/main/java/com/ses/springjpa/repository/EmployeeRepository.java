package com.ses.springjpa.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.ses.springjpa.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Employee findByEmpNo(String empNo);

    List<Employee> findByFullNameLike(String fullName);

    List<Employee> findByHireDateGreaterThan(Date hireDate);

    @Query("SELECT coalesce(max(e.id), 0) FROM Employee e")
    Long getMaxId();

}
