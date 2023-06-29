package com.ses.springjpa.dao;

import java.util.Date;

public interface EmployeeCustom {
    public Long getMaxEmpId();

    public long updateEmployee(Long empId, String fullName, Date hireDate);
}
