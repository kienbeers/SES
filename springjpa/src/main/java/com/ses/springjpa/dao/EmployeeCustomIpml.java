package com.ses.springjpa.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ses.springjpa.entity.Employee;

@Repository
public class EmployeeCustomIpml implements EmployeeCustom {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Long getMaxEmpId() {
        try {
            Query query = entityManager.createQuery("SELECT coalesce(max(e.id), 0) FROM Employee e");
            return (long) query.getSingleResult();
        } catch (NoResultException e) {
            return 0L;
        }
    }

    @Override
    public long updateEmployee(Long empId, String fullName, Date hireDate) {
        Employee e = entityManager.find(Employee.class, empId);
        if (e == null) {
            return 0;
        }
        e.setFullName(fullName);
        e.setHireDate(hireDate);
        entityManager.flush();
        return 1;
    }

}
